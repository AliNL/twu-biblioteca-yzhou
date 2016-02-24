package com.twu.biblioteca;

/**
 * Created by 思念 on 2016/2/22.
 */
public class AddItems {
    public static void addBooksAndMovies(){
        Library.Book("Introduction to Code Smells","auther1","2016");
        Library.Book("Code smells : Comments","auther2","2016");
        Library.Book("Code smells : Long methods","auther3","2016");
        Library.Book("book4","author4","2016");
        Library.Book("book5","author5","2016");

        Library.Movie("Define refactoring","director1","2016",10);
        Library.Movie("Why Refactor?","director2","2016", 9.8);
        Library.Movie("Introducing bad smells","director3","2016",9.2);
        Library.Movie("movie4","director4","2016",0);
        Library.Movie("movie5","director5","2016",0.3);
    }
    public static void addUsers(){
        Library.User("123-4567","abcdefg","yzhou","584342218@qq.com","18107196187");
        Library.User("123-4568","123456","txku","kutianxi@outlook.com","18102662343");
    }
}
