package com.twu.biblioteca;

/**
 * Created by 思念 on 2016/2/22.
 */
public class ShowMessage {

    public static void welcome() {
        System.out.println("Welcome to Biblioteca!");
        mainMenu();
    }

    public static void invalidOption() {
        System.out.println("Select a valid option!");
        mainMenu();
    }

    public static void successfulCheckout() {
        System.out.println("Thank you! Enjoy the book/movie");
    }

    public static void unSuccessfulCheckout() {
        System.out.println("That book/movie is not available.");
    }

    public static void successfulReturn() {
        System.out.println("Thank you for returning the book/movie.");
    }

    public static void unSuccessfulReturn() {
        System.out.println("That is not a valid book/movie to return.");
    }

    public static void mainMenu() {
        System.out.println("Here are the valid options:");
        System.out.println("input \"1\" to show the menu of valid options.");
        System.out.println("input \"2\" to show the list of the books not checked out.");
        System.out.println("input \"3\" to check out a book.");
        System.out.println("input \"4\" to return a book.");
        System.out.println("input \"5\" to show the list of the movies not checked out.");
        System.out.println("input \"6\" to check out a movie.");
        System.out.println("input \"7\" to return a movie.");
        System.out.println("input \"0\" to quit the application.");
    }

    public static void bookList() {
        System.out.println("Here are the valid books:");
        for (BookOrMovie item : Library.books)
            if (item.isNotCheckedOut())
                System.out.println(item.getName() + "\t" + item.getAuthorOrDirector() + "\t" + item.getPublishYear());
    }

    public static void movieList() {
        System.out.println("Here are the valid movies:");
        for (BookOrMovie item : Library.movies)
            if (item.isNotCheckedOut())
                System.out.println(item.getName() + "\t" + item.getAuthorOrDirector() + "\t" + item.getPublishYear()+ "\t" + item.getRating());
    }
}
