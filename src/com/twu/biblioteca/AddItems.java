package com.twu.biblioteca;

/**
 * Created by 思念 on 2016/2/22.
 */
public class AddItems {
    public static void addBooksAndMovies(){
        BookOrMovie.Book("Introduction to Code Smells","auther1","2016");
        BookOrMovie.Book("Code smells : Comments","auther2","2016");
        BookOrMovie.Book("Code smells : Long methods","auther3","2016");
        BookOrMovie.Book("book4","author4","2016");
        BookOrMovie.Book("book5","author5","2016");

        BookOrMovie.Movie("Define refactoring","director1","2016",10);
        BookOrMovie.Movie("Why Refactor?","director2","2016", 9.8);
        BookOrMovie.Movie("Introducing bad smells","director3","2016",9.2);
        BookOrMovie.Movie("movie4","director4","2016",7.5);
        BookOrMovie.Movie("movie5","director5","2016",0.3);
    }
    public static void addUsers(){
        new User("123-4567","abcdefg","yzhou","584342218@qq.com","18107196187");
        new User("123-4568","123456","txku","kutianxi@outlook.com","18102662343");
    }
}
