package io.schoolbolt.example.menu;

public abstract class MenuItem {
    private final String title;

    public MenuItem(String name) {
        this.title = name;
    }

    public String getTitle() {
        return title;
    }

    public abstract void run();
}
