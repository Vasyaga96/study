package org.example;

import java.time.LocalDate;

public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library();

        Book onegin = new Book("Онегин");
        library.addBook(onegin);
        Book deadSouls = new Book("Мертвые души");
        library.addBook(deadSouls);
        Book crimeAndPunishment = new Book("Преступление и наказание");
        library.addBook(crimeAndPunishment);
        Book warAndPeace = new Book("Война и мир");
        library.addBook(warAndPeace);
        Book masterAndMargarita = new Book("Мастер и маргарита");
        library.addBook(masterAndMargarita);
        Book HarryPotter = new Book("Гарри Поттер");
        library.addBook(HarryPotter);
        Book LordOfTheRings = new Book("Властелин колец");
        library.addBook(LordOfTheRings);

        library.showBooks();

        Reader vasyiliy = new Reader("Василий");
        LocalDate dateMustReturn = LocalDate.of(2024, 12, 20);
        library.takeBook(vasyiliy, "Онегин", dateMustReturn);
        System.out.println("Книги в библиотеке:");
        library.showBooks();
        System.out.println("Книги у " + vasyiliy.getName());
        vasyiliy.showBooksHave();

        library.returnBook(vasyiliy, "Онегин");
        System.out.println("Книги в библиотеке:");
        library.showBooks();
        System.out.println("Книги у " + vasyiliy.getName());
        vasyiliy.showBooksHave();
    }
}
