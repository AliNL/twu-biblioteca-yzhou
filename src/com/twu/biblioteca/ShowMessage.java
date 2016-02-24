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

    public static void successfulCheckOutOrReturn(boolean option) {
        if (option)
            System.out.println("Thank you! Enjoy the book/movie");
        else
            System.out.println("Thank you for returning the book/movie.");
    }

    public static void unSuccessfulCheckOutOrReturn(boolean option) {
        if (option)
            System.out.println("That book/movie is not available.");
        else
            System.out.println("That is not a valid book/movie to return.");
    }

    public static void successfulLogInOrOut(boolean option) {
        if (option)
            System.out.println("Log in successfully.");
        else
            System.out.println("Log out successfully.");
    }

    public static void unSuccessfulLogIn() {
        System.out.println("wrong library number or password");
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
            if (item.isNotCheckedOut()) {
                System.out.print(item.getName() + "\t" + item.getAuthorOrDirector() + "\t" + item.getPublishYear());
                if (item.getRating() > 0)
                    System.out.print("\t" + item.getRating());
                else
                    System.out.print("\tunrated");
            }
    }

    public static void userInformation(User user) {
        System.out.println("Here is your information:");
        System.out.println("LibraryNumber:" + user.getLibraryNumber());
        System.out.println("UserName:" + user.getUserName());
        System.out.println("EmailAddress:" + user.getEmailAddress());
        System.out.println("PhoneNumber:" + user.getPhoneNumber());
    }
}
