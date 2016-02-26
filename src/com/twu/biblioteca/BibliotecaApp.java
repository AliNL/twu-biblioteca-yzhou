package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Library library = new Library();
        AddItems.addLibrary(library);
        ShowMessage.show(0);
        int option = 1;
        while (option != 0) {
            controller(option, library);
            if (scanner.hasNextInt())
                option = scanner.nextInt();
            else {
                scanner.next();
                option = -1;
            }
        }
    }

    public static void controller(int option, Library library) {
        switch (option) {
            case 1:
                ShowMessage.mainMenu();
                break;
            case 2:
                ShowMessage.bookList(library);
                break;
            case 3:
                System.out.println("Please input the book to checkout:");
                scanner.nextLine();
                ShowMessage.show(library.checkoutBookByName(scanner.nextLine()));
                break;
            case 4:
                System.out.println("Please input the book to return:");
                scanner.nextLine();
                ShowMessage.show(library.returnBookByName(scanner.nextLine()));
                break;
            case 5:
                ShowMessage.movieList(library);
                break;
            case 6:
                System.out.println("Please input the movie to checkout:");
                scanner.nextLine();
                ShowMessage.show(library.checkoutMovieByName(scanner.nextLine()));
                break;
            case 7:
                System.out.println("Please input the movie to return:");
                scanner.nextLine();
                ShowMessage.show(library.returnMovieByName(scanner.nextLine()));
                break;
            case 8:
                System.out.println("Please input your library number:");
                String number = scanner.next();
                System.out.println("Please input your password:");
                ShowMessage.show(library.userLogIn(number, scanner.next()));
                break;
            case 9:
                ShowMessage.show(library.userLogOut());
                break;
            case 10:
                ShowMessage.show(library.showUserInformation());
            case 0:
                return;
            default:
                ShowMessage.show(1);
        }
    }
}
