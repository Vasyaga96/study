package io.schoolbolt.example.menu;

public class SimpleController {
    private final Menu mainMenu;
    private final SimpleRepository repository;

    public SimpleController(Menu mainMenu, SimpleRepository repository) {
        this.mainMenu = mainMenu;
        this.repository = repository;

        initMenu();
    }

    private void initMenu() {
        mainMenu.addItem("Пункт 1", () -> System.out.println("Hello, World!"));
        Menu submenu = mainMenu.addSubmenu("Подменю");
        submenu.addItem("Пункт в подменю", () -> repository.save("test"));
    }
}
