package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 思念 on 2016/2/23.
 */
public class Library {
    public static List<BookOrMovie> books = new ArrayList<BookOrMovie>();
    public static List<BookOrMovie> movies = new ArrayList<BookOrMovie>();
    public static List<User> users = new ArrayList<User>();
    public static User userNow;

    public static void Book(String name, String author, String publishYear) {
        books.add(new BookOrMovie(name, author, publishYear, -1));
    }

    public static void Movie(String name, String director, String publishYear, double rating) {
        movies.add(new BookOrMovie(name, director, publishYear, rating));
    }

    public static void User(String libraryNumber, String passWord, String userName, String emailAddress, String phoneNumber) {
        users.add(new User(libraryNumber, passWord, userName, emailAddress, phoneNumber));
    }

    public static boolean findItemByName(String name, boolean option, boolean whichList) {
        List<BookOrMovie> list = whichList ? books : movies;
        for (BookOrMovie item : list)
            if (name.equals(item.getName())) {
                return item.checkOutOrReturn(option, whichList ? userNow.getBooks() : userNow.getMovies());
            }
        return false;
    }

    public static boolean findUserByNumber(String libraryNumber, String passWord) {
        for (User item : users) {
            if (libraryNumber.equals(item.getLibraryNumber()) && passWord.hashCode() == item.getPassWord()) {
                userNow = item;
                return true;
            }
        }
        return false;
    }
}
