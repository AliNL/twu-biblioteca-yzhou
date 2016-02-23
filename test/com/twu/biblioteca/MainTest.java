package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 思念 on 2016/2/22.
 */
public class MainTest {

    private Book book;

    @Before
    public void setUp() {
        book = new Book("name", "author", "2016");
    }


    @Test
    public void should_be_checked_out_only_once() {
        assertTrue(book.checkOut());
        assertFalse(book.checkOut());
    }

    @Test
    public void should_be_returned_only_once() {
        book.checkOut();
        assertTrue(book.returnBook());
        assertFalse(book.returnBook());
    }

    @Test
    public void should_be_checked_out_again_after_return() {
        book.checkOut();
        assertTrue(book.returnBook());
        assertTrue(book.checkOut());
    }

    @Test
    public void should_check_out_a_valid_book(){
        assertTrue(Library.findBookByName(book.getName(),true));
    }

    @Test
    public void should_not_check_out_a_invalid_book() {
        assertFalse(Library.findBookByName("not exist",true));
    }

}
