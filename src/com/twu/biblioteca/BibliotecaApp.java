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
                checkOutOrReturn(BOOK, CHECK_OUT);
                break;
            case '4':
                checkOutOrReturn(BOOK, RETURN_ITEM);
                break;
            case '5':
                ShowMessage.movieList();
                break;
            case '6':
                checkOutOrReturn(MOVIE, CHECK_OUT);
                break;
            case '7':
                checkOutOrReturn(MOVIE, RETURN_ITEM);
                break;
            case '8':
                userLogInOrOut(LOG_IN);
                break;
            case '9':
                userLogInOrOut(LOG_OUT);
                break;
            case 'a':
                ShowMessage.userInformation(Library.userNow);
            case '0':
                return;
            default:
                ShowMessage.invalidOption();
        }
    }

    public static void checkOutOrReturn(boolean bookOrMovie, boolean option) {
        if (Library.userNow != null) {
            if (option)
                System.out.println("Please input the book/movie to check out");
            else
                System.out.println("Please input the book/movie to return");
            scanner.nextLine();
            String name = scanner.nextLine();
            ShowMessage.CheckOutOrReturn(bookOrMovie, option, Library.findItemByName(name, option, bookOrMovie));
        } else
            System.out.println("Please log in first.");
    }

    public static void userLogInOrOut(boolean option) {
        if (!option) {
            Library.userNow = null;
            ShowMessage.LogInOrOut(LOG_OUT,SUCCESSFUL);
        } else {
            System.out.println("Please input the library number");
            String libraryNumber = scanner.next();
            System.out.println("Please input the password");
            String passWord = scanner.next();
            ShowMessage.LogInOrOut(LOG_IN,Library.findUserByNumber(libraryNumber, passWord));
        }
    }

    private static final boolean CHECK_OUT = true;
    private static final boolean RETURN_ITEM = false;
    private static final boolean BOOK = true;
    private static final boolean MOVIE = false;
    private static final boolean LOG_IN = true;
    private static final boolean LOG_OUT = false;
    private static final boolean SUCCESSFUL = true;
}
