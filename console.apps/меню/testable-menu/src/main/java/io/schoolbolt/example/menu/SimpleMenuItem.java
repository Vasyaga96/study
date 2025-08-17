package io.schoolbolt.example.menu;

public class SimpleMenuItem extends MenuItem {
    private final Runnable action;

    public SimpleMenuItem(String name, Runnable action) {
        super(name);
        this.action = action;
    }

    @Override
    public void run() {
        action.run();
    }
}
