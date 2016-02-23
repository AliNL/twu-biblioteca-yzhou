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

    public static boolean findItemByName(String name, boolean option, boolean whichList) {
        List<BookOrMovie> list = whichList ? books : movies;
        for (BookOrMovie item : list) {
            if (name.equals(item.getName())) {
                if (option)
                    return item.checkOut();
                else
                    return item.returnItem();
            }
        }
        return false;
    }

    public static boolean findItemByName(String libraryNumber, boolean option, String passWord) {
        for (User item : users) {
            if (libraryNumber.equals(item.getLibraryNumber())) {
                if (!option) {
                    item.logOut();
                    return true;
                } else {
                    if (passWord.hashCode() == item.getPassWord()) {
                        item.logIn();
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
