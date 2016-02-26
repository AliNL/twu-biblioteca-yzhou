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

    public User(String libraryNumber, String passWord, String userName, String emailAddress, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.passWord = passWord.hashCode();
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public void getUserInformation() {
        System.out.println("Here is your information:");
        System.out.println("LibraryNumber:" + this.libraryNumber);
        System.out.println("UserName:" + this.userName);
        System.out.println("EmailAddress:" + this.emailAddress);
        System.out.println("PhoneNumber:" + this.phoneNumber);
    }

    public String getLibraryNumber() {
        return this.libraryNumber;
    }

    public int getPassWord() {
        return this.passWord;
    }
}
