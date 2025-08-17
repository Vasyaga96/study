package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu extends Item {
    private List<Item> items = new ArrayList<>();
    private boolean running;
    Runnable onStart;
    Runnable afterChoice;
    Runnable onClose;

    public Menu(){
        super("");
    }
    public Menu(String title){
        super(title);
    }


    public void addMenu(String title){
        items.add(new Menu(title));
    }

    public void addSimpleItem(String title, Runnable action){
        items.add(new SimpleItem(title, action));
    }


    @Override
    public void run() {
        showMenu();
        selectMenu();
    }

    private void showMenu(){
        for (int i = 0; i < items.size(); i++){
            Item item = items.get(i);
            System.out.println((i + 1) + "." + item.getTitle());
        }
    }
    private void selectMenu(){
        running = true;
        Scanner scanner = new Scanner(System.in);

        while (running) {
            System.out.println(getTitle());
            showMenu();
            System.out.print("Выберите пункт: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == items.size() + 1){
                    running = false;
                }else if (choice >= 1 && choice <= items.size()) {
                    items.get(choice - 1).run();
                } else {
                    System.out.println("Некорректный пункт. Попробуйте еще раз.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите номер пункта.");
            }
        }
    }

}
