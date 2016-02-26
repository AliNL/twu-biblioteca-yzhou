package com.twu.biblioteca;

/**
 * Created by 思念 on 2016/2/26.
 */
public class CheckoutItem {
    private String userLibraryNumber;
    private String name;
    private boolean isBook;

    public CheckoutItem(String userLibraryNumber, String name, boolean isBook) {
        this.userLibraryNumber = userLibraryNumber;
        this.name = name;
        this.isBook = isBook;
    }

    public int getRecord() {
        return (userLibraryNumber + name + isBook).hashCode();
    }
}
