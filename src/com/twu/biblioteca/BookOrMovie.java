package com.twu.biblioteca;

/**
 * Created by 思念 on 2016/2/22.
 */
public class BookOrMovie {
    private String name, authorOrDirector, publishYear;
    private double rating;
    private boolean notCheckedOut;

    public BookOrMovie(String name, String authorOrDirector, String publishYear, double rating) {
        this.name = name;
        this.authorOrDirector = authorOrDirector;
        this.publishYear = publishYear;
        this.rating = rating;
        this.notCheckedOut = true;
    }

    public static void Book(String name, String authorOrDirector, String publishYear) {
        Library.books.add(new BookOrMovie(name, authorOrDirector, publishYear, -1));
    }

    public static void Movie(String name, String authorOrDirector, String publishYear, double rating){
        Library.movies.add( new BookOrMovie(name, authorOrDirector, publishYear, rating));
    }

    public String getName() {
        return this.name;
    }

    public String getAuthorOrDirector() {
        return this.authorOrDirector;
    }

    public String getPublishYear() {
        return this.publishYear;
    }

    public double getRating() {
        return this.rating;
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

    public boolean returnItem() {
        if (!this.notCheckedOut)
            this.notCheckedOut = true;
        else
            return false;
        return true;
    }
}
