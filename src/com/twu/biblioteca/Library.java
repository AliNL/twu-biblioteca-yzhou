package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 思念 on 2016/2/23.
 */
public class Library {
    private List<BookOrMovie> books = new ArrayList<BookOrMovie>();
    private List<BookOrMovie> movies = new ArrayList<BookOrMovie>();
    private List<User> users = new ArrayList<User>();
    private List<CheckoutItem> checkoutItems = new ArrayList<CheckoutItem>();
    private User userNow;

    public void addBook(String name, String author, String publishYear) {
        books.add(new BookOrMovie(name, author, publishYear, -1));
    }

    public void addMovie(String name, String director, String publishYear, double rating) {
        movies.add(new BookOrMovie(name, director, publishYear, rating));
    }

    public void addUser(String libraryNumber, String passWord, String userName, String emailAddress, String phoneNumber) {
        users.add(new User(libraryNumber, passWord, userName, emailAddress, phoneNumber));
    }

    public void getBooks() {
        for (BookOrMovie book : books)
            book.getBookInformation();
    }

    public void getMovies() {
        for (BookOrMovie movie : movies)
            movie.getMovieInformation();
    }

    public int checkoutBookByName(String bookName) {
        if (userNow == null)
            return NOT_LOG_IN;
        BookOrMovie item = findItemByName(bookName, books);
        if (item != null) {
            if (item.checkOut()) {
                addCheckoutItem(userNow.getLibraryNumber(), item.getName(), true);
                return BOOK_CHECKOUT_SUCCESSFUL;
            }
        }
        return BOOK_CHECKOUT_UNSUCCESSFUL;
    }

    public int checkoutMovieByName(String movieName) {
        if (userNow == null)
            return NOT_LOG_IN;
        BookOrMovie item = findItemByName(movieName, movies);
        if (item != null) {
            if (item.checkOut()) {
                addCheckoutItem(userNow.getLibraryNumber(), item.getName(), false);
                return MOVIE_CHECKOUT_SUCCESSFUL;
            }
        }
        return MOVIE_CHECKOUT_UNSUCCESSFUL;
    }

    public int returnBookByName(String bookName) {
        if (userNow == null)
            return NOT_LOG_IN;
        BookOrMovie item = findItemByName(bookName, books);
        if (item != null) {
            if (deleteCheckoutItem(userNow.getLibraryNumber(), item.getName(), true)) {
                item.returnItem();
                return BOOK_RETURN_SUCCESSFUL;
            }
        }
        return BOOK_RETURN_UNSUCCESSFUL;
    }

    public int returnMovieByName(String movieName) {
        if (userNow == null)
            return NOT_LOG_IN;
        BookOrMovie item = findItemByName(movieName, movies);
        if (item != null) {
            if (deleteCheckoutItem(userNow.getLibraryNumber(), item.getName(), false)) {
                item.returnItem();
                return MOVIE_RETURN_SUCCESSFUL;
            }
        }
        return MOVIE_RETURN_UNSUCCESSFUL;
    }

    public int showUserInformation() {
        if (userNow == null)
            return NOT_LOG_IN;
        else {
            userNow.getUserInformation();
            return SUCCESSFUL;
        }
    }

    public int userLogIn(String libraryNumber, String passWord) {
        for (User item : users) {
            if (libraryNumber.equals(item.getLibraryNumber()) && passWord.hashCode() == item.getPassWord()) {
                userNow = item;
                return LOG_IN_SUCCESSFUL;
            }
        }
        return LOG_IN_UNSUCCESSFUL;
    }

    public int userLogOut() {
        userNow = null;
        return LOG_OUT_SUCCESSFUL;
    }

    private static BookOrMovie findItemByName(String name, List<BookOrMovie> list) {
        for (BookOrMovie item : list)
            if (name.equals(item.getName()))
                return item;
        return null;
    }

    private void addCheckoutItem(String libraryNumber, String name, boolean isBook) {
        checkoutItems.add(new CheckoutItem(libraryNumber, name, isBook));
    }

    private boolean deleteCheckoutItem(String libraryNumber, String name, boolean isBook) {
        CheckoutItem tempRecord = new CheckoutItem(libraryNumber, name, isBook);
        for (CheckoutItem record : checkoutItems) {
            if (tempRecord.getRecord() == record.getRecord()) {
                checkoutItems.remove(record);
                return true;
            }
        }
        return false;
    }

    private static final int NOT_LOG_IN = 2;
    private static final int BOOK_CHECKOUT_SUCCESSFUL = 3;
    private static final int BOOK_CHECKOUT_UNSUCCESSFUL = 4;
    private static final int BOOK_RETURN_SUCCESSFUL = 5;
    private static final int BOOK_RETURN_UNSUCCESSFUL = 6;
    private static final int MOVIE_CHECKOUT_SUCCESSFUL = 7;
    private static final int MOVIE_CHECKOUT_UNSUCCESSFUL = 8;
    private static final int MOVIE_RETURN_SUCCESSFUL = 9;
    private static final int MOVIE_RETURN_UNSUCCESSFUL = 10;
    private static final int LOG_IN_SUCCESSFUL = 11;
    private static final int LOG_IN_UNSUCCESSFUL = 12;
    private static final int LOG_OUT_SUCCESSFUL = 13;
    private static final int SUCCESSFUL = 14;
}
