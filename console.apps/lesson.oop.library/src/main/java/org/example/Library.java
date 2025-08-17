package org.example;

import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book){
        books.add(book);         
    }

    public void showBooks(){
        for (int i = 0;i < books.size() - 1;i++){
            System.out.println(books.get(i).getName());
        }
    }

    public void takeBook(Reader reader, String nameBook, LocalDate dateMustReturn){
        for (int i = 0; i < books.size() - 1; i++){
            if (books.get(i).getName().equals(nameBook)){
                Book takesBook = books.get(i);
                books.remove(i);
                ListReaders listReadersTakeBook = new ListReaders(reader, LocalDate.now(), dateMustReturn);
                takesBook.getListReaders().add(listReadersTakeBook);
                reader.addBook(takesBook);
            }else {
                System.out.println("Такой книги в библиотеке нету :(");
            }
        }
    }

    public void returnBook(Reader reader, String nameBook){
        for (int i = 0; i < reader.getBooksHave().size() - 1; i++){
            if (reader.getBooksHave().get(i).getName().equals(nameBook)){
                Book booksReturn = reader.getBooksHave().get(i);
                reader.getBooksHave().remove(i);
                booksReturn.getListReaders().getLast().setDateReturn(LocalDate.now());
                books.add(booksReturn);
            }else {
                System.out.println("Такой книги у читателя не нашлось :(");
            }
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
