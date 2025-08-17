package org.example;

import java.time.LocalDate;

public class ListReaders {
    private Reader reader;
    private LocalDate dateTook;
    private LocalDate dateMustReturn;
    private LocalDate dateReturn;

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public LocalDate getDateTook() {
        return dateTook;
    }

    public void setDateTook(LocalDate dateTook) {
        this.dateTook = dateTook;
    }

    public LocalDate getDateMustReturn() {
        return dateMustReturn;
    }

    public void setDateMustReturn(LocalDate dateMustReturn) {
        this.dateMustReturn = dateMustReturn;
    }

    public LocalDate getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(LocalDate dateReturn) {
        this.dateReturn = dateReturn;
    }

    public ListReaders(Reader reader, LocalDate dateTook, LocalDate dateMustReturn){
        this.reader = reader;
        this.dateTook = dateTook;
        this.dateMustReturn = dateMustReturn;
    }

    public ListReaders(Reader reader, LocalDate dateTook, LocalDate dateMustReturn, LocalDate dateReturn){
        this.reader = reader;
        this.dateTook = dateTook;
        this.dateMustReturn = dateMustReturn;
        this.dateReturn = dateReturn;
    }
}
