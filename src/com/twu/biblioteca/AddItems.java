package com.twu.biblioteca;

/**
 * Created by 思念 on 2016/2/22.
 */
public class AddItems {
    public static void addLibrary(Library library) {
        library.addBook("Introduction to Code Smells", "auther1", "2016");
        library.addBook("Code smells : Comments", "auther2", "2016");
        library.addBook("Code smells : Long methods", "auther3", "2016");
        library.addBook("book4", "author4", "2016");
        library.addBook("book5", "author5", "2016");

        library.addMovie("Define refactoring", "director1", "2016", 10);
        library.addMovie("Why Refactor?", "director2", "2016", 9.8);
        library.addMovie("Introducing bad smells", "director3", "2016", 9.2);
        library.addMovie("movie4", "director4", "2016", 0);
        library.addMovie("movie5", "director5", "2016", 0.3);

        library.addUser("123-4567", "abcdefg", "yzhou", "584342218@qq.com", "18107196187");
        library.addUser("123-4568", "123456", "txku", "kutianxi@outlook.com", "18102662343");
    }
}
