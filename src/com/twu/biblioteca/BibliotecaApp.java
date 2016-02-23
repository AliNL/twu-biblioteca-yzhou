package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ShowMessage.welcome();
        AddItems.addBooksAndMovies();
        AddItems.addUsers();
        String option = scanner.next();
        while (!option.contains("0")) {
            controller(option);
            option = scanner.next();
        }
    }


    public static void controller(String option) {
        switch (option.charAt(0)) {
            case '1':
                ShowMessage.mainMenu();
                break;
            case '2':
                ShowMessage.bookList();
                break;
            case '3':
                checkOutOrReturn(BOOK,CHECK_OUT);
                break;
            case '4':
                checkOutOrReturn(BOOK,RETURN_ITEM);
                break;
            case '5':
                ShowMessage.movieList();
                break;
            case '6':
                checkOutOrReturn(MOVIE,CHECK_OUT);
                break;
            case '7':
                checkOutOrReturn(MOVIE,RETURN_ITEM);
                break;
            case '8':
                userLogInOrOut(LOG_IN);
                break;
            case '9':
                userLogInOrOut(LOG_OUT);
                break;
            case 'a':
                ShowMessage.
            case '0':
                return;
            default:
                ShowMessage.invalidOption();
        }
    }

    public static void checkOutOrReturn(boolean bookOrMovie,boolean option) {
        if (Library.userNow!=null) {
            if(option)
            System.out.println("Please input the book/movie to check out");
            else
                System.out.println("Please input the book/movie to return");
            scanner.nextLine();
            String name = scanner.nextLine();
            if (Library.findItemByName(name, option, bookOrMovie))
                ShowMessage.successfulCheckOutOrReturn(option);
            else
                ShowMessage.unSuccessfulCheckOutOrReturn(option);
        } else
            System.out.println("Please log in first.");
    }

    public static void userLogInOrOut(boolean option) {
        System.out.println("Please input the library number");
        String libraryNumber = scanner.next();
        System.out.println("Please input the password");
        String passWord = scanner.next();
        if (Library.findItemByName(libraryNumber,option ,passWord))
            ShowMessage.successfulLogInOrOut(option);
        else
            ShowMessage.unSuccessfulLogInOrOut(option);
    }

    public static final boolean CHECK_OUT = true;
    public static final boolean RETURN_ITEM = false;
    public static final boolean BOOK = true;
    public static final boolean MOVIE = false;
    public static final boolean LOG_IN = true;
    public static final boolean LOG_OUT = false;

}
