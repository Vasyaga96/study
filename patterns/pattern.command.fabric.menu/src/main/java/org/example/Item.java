package org.example;

public abstract class Item {
    private String title;

    public Item(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract void run();
}
