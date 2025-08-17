package org.example;

public class SimpleItem extends Item {
    private Runnable action;

    public SimpleItem(String title, Runnable action){
        super(title);
        this.action = action;
    }
    @Override
    public void run() {
        action.run();
    }
}
