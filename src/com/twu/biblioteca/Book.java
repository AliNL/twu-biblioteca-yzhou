package com.twu.biblioteca;

/**
 * Created by 思念 on 2016/2/22.
 */
public class Book {
    private String name, author, publishYear;
    private boolean notCheckedOut;

    public Book(String name, String author, String publishYear) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
        this.notCheckedOut = true;
        Library.books.add(this);
    }

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getPublishYear() {
        return this.publishYear;
    }

    public boolean isNotCheckedOut() {
        return notCheckedOut;
    }

    public boolean checkOut() {
        if (this.notCheckedOut)
            this.notCheckedOut = false;
        else
            return false;
        return true;
    }

    public boolean returnBook() {
        if (!this.notCheckedOut)
            notCheckedOut = true;
        else
            return false;
        return true;
    }
}
