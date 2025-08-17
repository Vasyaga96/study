package org.example;


import java.util.ArrayList;

public class Reader {
    private String name;
    private ArrayList<Book> booksHave = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Book> getBooksHave() {
        return booksHave;
    }

    public void setBooksHave(ArrayList<Book> booksHave) {
        this.booksHave = booksHave;
    }

    public Reader(String name){
        this.name = name;
    }
    public void addBook(Book book){
        booksHave.add(book);
    }

    public void showBooksHave(){
        for (int i = 0; i < booksHave.size() - 1; i++){
            booksHave.get(i).showBook();
        }
    }
}
