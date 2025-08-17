package io.schoolbolt.example.menu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SimpleControllerTest {
    @Test
    void testCallSubmenu() {
        Menu mainMenu = spy(new Menu());
        doAnswer(invocation -> {
            Menu submenu = spy((Menu) invocation.callRealMethod());
            doAnswer(subInvocation -> {
                submenu.selectMenuItem(1);
                return null;
            }).when(submenu).run();

            return submenu;
        }).when(mainMenu).createSubmenu(anyString());

        SimpleRepository repository = mock(SimpleRepository.class);

        new SimpleController(mainMenu, repository);

        mainMenu.selectMenuItem(2);

        verify(repository).save("test");
    }
}
