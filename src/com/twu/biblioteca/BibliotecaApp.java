package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ShowMessage.welcome();
        AddBooks.addBooks();
        String option = scanner.next();
        while (!option.contains("0")) {
            controller(option);
            option = scanner.next();
        }
    }


    public static void controller(String option) {
        String bookName;
        switch (option.charAt(0)) {
            case '1':
                ShowMessage.mainMenu();
                break;
            case '2':
                ShowMessage.bookList();
                break;
            case '3':
                System.out.println("Please input the book to check out");
                scanner.nextLine();
                bookName = scanner.nextLine();
                if (Library.findBookByName(bookName, CHECK_OUT))
                    ShowMessage.successfulCheckout();
                else
                    ShowMessage.unSuccessfulCheckout();
                break;
            case '4':
                System.out.println("Please input the book to return");
                scanner.nextLine();
                bookName = scanner.nextLine();
                if (Library.findBookByName(bookName, RETURN_BOOK))
                    ShowMessage.successfulReturn();
                else
                    ShowMessage.unSuccessfulReturn();
                break;
            case '0':
                return;
            default:
                ShowMessage.invalidOption();
        }
    }

    public static final boolean CHECK_OUT = true;
    public static final boolean RETURN_BOOK = false;
}
