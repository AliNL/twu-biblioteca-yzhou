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

    public void getBookInformation() {
        if (notCheckedOut)
            System.out.println(name + "\t" + authorOrDirector + "\t" + publishYear);
    }

    public void getMovieInformation() {
        if (notCheckedOut) {
            System.out.print(name + "\t" + authorOrDirector + "\t" + publishYear);
            if (this.rating > 0)
                System.out.println("\t" + rating);
            else
                System.out.println("\t" + "unrated");
        }
    }

    public String getName() {
        return name;
    }

    public boolean checkOut() {
        if (!notCheckedOut)
            return false;
        else {
            notCheckedOut = false;
            return true;
        }
    }

    public boolean returnItem() {
        if (notCheckedOut)
            return false;
        else {
            notCheckedOut = true;
            return true;
        }
    }
}
