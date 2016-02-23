package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 思念 on 2016/2/23.
 */
public class Library {
    public static List<Book> books = new ArrayList<Book>();

    public static boolean findBookByName(String bookName, boolean option) {
        for (Book book : books) {
            if (bookName.equals(book.getName())) {
                if (option)
                    return book.checkOut();
                else
                    return book.returnBook();
            }
        }
        return false;
    }
}
