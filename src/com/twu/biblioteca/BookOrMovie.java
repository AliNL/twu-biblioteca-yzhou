package com.twu.biblioteca;

import java.util.List;

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
        if (this.notCheckedOut)
            System.out.println(this.name + "\t" + this.authorOrDirector + "\t" + this.publishYear);
    }

    public void getMovieInformation() {
        if (this.notCheckedOut) {
            System.out.print(this.name + "\t" + this.authorOrDirector + "\t" + this.publishYear);
            if (this.rating > 0)
                System.out.println("\t" + this.rating);
            else
                System.out.println("\t" + "unrated");
        }

    }

    public String getName() {
        return this.name;
    }

    public boolean checkOutOrReturn(boolean option, List<BookOrMovie> list) {
        if (this.notCheckedOut != option) {
            return false;
        } else {
            this.notCheckedOut = !option;
            if (option)
                list.add(this);
            else
                list.remove(this);
            return true;
        }
    }
}
