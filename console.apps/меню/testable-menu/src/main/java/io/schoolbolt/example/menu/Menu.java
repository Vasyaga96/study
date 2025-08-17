package io.schoolbolt.example.menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu extends MenuItem {
    private final List<MenuItem> items = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private final boolean isSubmenu;
    private boolean isRunning = false;
    private MenuLifecycleHook onStartHook = null;
    private MenuLifecycleHook onShowHook = null;
    private MenuLifecycleHook onCloseHook = null;

    public Menu() {
        super("");
        isSubmenu = false;
    }

    private Menu(String title) {
        super(title);
        isSubmenu = true;
    }

    public void onStart(MenuLifecycleHook onStartHook) {
        this.onStartHook = onStartHook;
    }

    public void onShow(MenuLifecycleHook onShowHook) {
        this.onShowHook = onShowHook;
    }

    public void onClose(MenuLifecycleHook onCloseHook) {
        this.onCloseHook = onCloseHook;
    }

    public void addItem(String title, Runnable action) {
        items.add(new SimpleMenuItem(title, action));
    }

    public Menu addSubmenu(String title) {
        Menu submenu = createSubmenu(title);
        items.add(submenu);
        return submenu;
    }

    protected Menu createSubmenu(String title) {
        return new Menu(title);
    }

    public void selectMenuItem(int index) {
        if (index <= 0 || index > items.size() + 1) return;

        if (index == items.size() + 1) {
            isRunning = false;
            return;
        }

        items.get(index - 1).run();
    }

    @Override
    public void run() {
        isRunning = true;
        runHook(onStartHook);

        while (isRunning) {
            runHook(onShowHook);

            printMenu();
            int choice = getUserInput();
            selectMenuItem(choice);
        }

        runHook(onCloseHook);
    }

    private void runHook(MenuLifecycleHook hook) {
        if (hook == null) return;

        try {
            hook.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            isRunning = false;
        }
    }

    private void printMenu() {
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, items.get(i).getTitle());
        }
        System.out.printf("%d. %s\n", items.size() + 1, isSubmenu ? "Назад" : "Выход");
    }

    private int getUserInput() {
        while (true) {
            try {
                System.out.print("> ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Номер пункта меню это целое число");
            }
        }
    }
}
