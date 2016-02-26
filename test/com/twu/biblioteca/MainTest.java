package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Created by 思念 on 2016/2/22.
 */
public class MainTest {
    private Library library;

    @Before
    public void setUp() {
        library = new Library();
        library.addBook("testBook", "author", "2016");
        library.addMovie("testMovie", "director", "2016", 9.8);
        library.addUser("111-1111", "123456", "testUser1", "584342218@qq.com", "18107196187");
        library.addUser("222-2222", "234567", "testUser2", "kutianxi@outlook.com", "18102662343");
        library.userLogIn("111-1111", "123456");
    }

    @Test
    public void should_not_log_in_with_wrong_number_or_password(){
        assertEquals(LOG_OUT_SUCCESSFUL,library.userLogOut());
        assertEquals(LOG_IN_UNSUCCESSFUL,library.userLogIn("123-4567","123456"));
        assertEquals(LOG_IN_UNSUCCESSFUL,library.userLogIn("111-1111","abcdefg"));
        assertEquals(LOG_IN_SUCCESSFUL,library.userLogIn("111-1111","123456"));
    }

    @Test
    public void should_not_show_user_information_without_log_in() {
        library.userLogOut();
        assertEquals(NOT_LOGGED_IN, library.showUserInformation());
        library.userLogIn("111-1111", "123456");
        assertEquals(SUCCESSFUL, library.showUserInformation());
    }

    @Test
    public void should_not_check_out_or_return_without_log_in() {
        library.userLogOut();
        assertEquals(NOT_LOGGED_IN, library.checkoutBookByName("testBook"));
        assertEquals(NOT_LOGGED_IN, library.returnBookByName("testBook"));
        assertEquals(NOT_LOGGED_IN, library.checkoutMovieByName("testMovie"));
        assertEquals(NOT_LOGGED_IN, library.returnMovieByName("testMovie"));
    }

    @Test
    public void should_check_out_same_book_or_movie_only_once() {
        assertEquals(BOOK_CHECKOUT_SUCCESSFUL, library.checkoutBookByName("testBook"));
        assertEquals(BOOK_CHECKOUT_UNSUCCESSFUL, library.checkoutBookByName("testBook"));
        assertEquals(MOVIE_CHECKOUT_SUCCESSFUL, library.checkoutMovieByName("testMovie"));
        assertEquals(MOVIE_CHECKOUT_UNSUCCESSFUL, library.checkoutMovieByName("testMovie"));
    }

    @Test
    public void should_return_same_book_or_movie_only_once() {
        library.checkoutBookByName("testBook");
        assertEquals(BOOK_RETURN_SUCCESSFUL, library.returnBookByName("testBook"));
        assertEquals(BOOK_RETURN_UNSUCCESSFUL, library.returnBookByName("testBook"));

        library.checkoutMovieByName("testMovie");
        assertEquals(MOVIE_RETURN_SUCCESSFUL, library.returnMovieByName("testMovie"));
        assertEquals(MOVIE_RETURN_UNSUCCESSFUL, library.returnMovieByName("testMovie"));
    }

    @Test
    public void should_checkout_again_after_return() {
        assertEquals(BOOK_CHECKOUT_SUCCESSFUL, library.checkoutBookByName("testBook"));
        assertEquals(BOOK_RETURN_SUCCESSFUL, library.returnBookByName("testBook"));
        assertEquals(BOOK_CHECKOUT_SUCCESSFUL, library.checkoutBookByName("testBook"));

        assertEquals(MOVIE_CHECKOUT_SUCCESSFUL, library.checkoutMovieByName("testMovie"));
        assertEquals(MOVIE_RETURN_SUCCESSFUL, library.returnMovieByName("testMovie"));
        assertEquals(MOVIE_CHECKOUT_SUCCESSFUL, library.checkoutMovieByName("testMovie"));
    }

    @Test
    public void should_not_return_item_checked_out_by_other_user(){
        library.checkoutBookByName("testBook");
        library.userLogOut();
        library.userLogIn("222-2222","234567");
        assertEquals(BOOK_RETURN_UNSUCCESSFUL,library.returnBookByName("testBook"));
    }

    private static final int NOT_LOGGED_IN = 2;
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
