    package org.example;

    import java.util.ArrayList;

    public class Book {
        private String name;
        private ArrayList<ListReaders> listReaders;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ArrayList<ListReaders> getListReaders() {
            return listReaders;
        }

        public void setListReaders(ArrayList<ListReaders> listReaders) {
            this.listReaders = listReaders;
        }

        public Book(){}

        public Book(String name){
            this.name = name;
        }
        public void showBook(){
            System.out.println(name);
        }


    }
