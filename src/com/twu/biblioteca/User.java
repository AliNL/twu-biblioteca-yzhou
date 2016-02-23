package com.twu.biblioteca;

/**
 * Created by 思念 on 2016/2/23.
 */
public class User {
    private String libraryNumber;
    private int passWord;
    private String userName;
    private String emailAddress;
    private String phoneNumber;
    public static boolean loggedIn;

    public User(String libraryNumber, String passWord, String userName, String emailAddress, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.passWord = passWord.hashCode();
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        Library.users.add(this);
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public int getPassWord() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void logIn() {
        loggedIn = true;
    }

    public void logOut() {
        loggedIn = false;
    }

}
