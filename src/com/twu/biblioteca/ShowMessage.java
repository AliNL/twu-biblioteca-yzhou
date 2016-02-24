package com.twu.biblioteca;

/**
 * Created by 思念 on 2016/2/22.
 */
public class ShowMessage {

    private static String[] message = {
            "Welcome to Biblioteca!",
            "Select a valid option!",
            "Please log in first.",

            "Thank you! Enjoy the book.",
            "That book is not available.",
            "Thank you for returning the book.",
            "That is not a valid book to return.",

            "Thank you! Enjoy the movie.",
            "That movie is not available.",
            "Thank you for returning the movie.",
            "That is not a valid movie to return.",

            "Log in successfully.",
            "Wrong library number or password.",
            "Log out successfully."
    };

    public static void welcome() {
        System.out.println(message[0]);
        mainMenu();
    }

    public static void invalidOption() {
        System.out.println(message[1]);
        mainMenu();
    }

    public static void CheckOutOrReturn(boolean bookOrMovie, boolean option, boolean isSuccessful) {
        int messageNumber;
        messageNumber = bookOrMovie ? BOOK : MOVIE;
        messageNumber += option ? CHECK_OUT : RETURN;
        messageNumber += isSuccessful ? SUCCESSFUL : UNSUCCESSFUL;
        System.out.println(message[messageNumber]);
    }

    public static void LogInOrOut(boolean option, boolean isSuccessful) {
        int messageNumber;
        messageNumber = option ? LOG_IN : LOG_OUT;
        messageNumber += isSuccessful ? SUCCESSFUL : UNSUCCESSFUL;
        System.out.println(message[messageNumber]);
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
        System.out.println("input \"8\" to log in.");
        System.out.println("input \"9\" to log out.");
        System.out.println("input \"a\" to show user information.");
        System.out.println("input \"0\" to quit the application.");
    }

    public static void bookList() {
        System.out.println("Here are the valid books:");
        for (BookOrMovie item : Library.books)
            item.getBookInformation();
    }

    public static void movieList() {
        System.out.println("Here are the valid movies:");
        for (BookOrMovie item : Library.movies)
            item.getMovieInformation();
    }

    public static void userInformation(User user) {
        System.out.println("Here is your information:");
        user.getUserInformation();
    }

    private static final int BOOK = 3;
    private static final int MOVIE = 7;
    private static final int CHECK_OUT = 0;
    private static final int RETURN = 2;
    private static final int SUCCESSFUL = 2;
    private static final int UNSUCCESSFUL = 2;
    private static final int LOG_IN = 11;
    private static final int LOG_OUT = 13;
}
