package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 思念 on 2016/2/22.
 */
public class MainTest {

    private BookOrMovie item;
    @Before
    public void setUp() {
        item = new BookOrMovie("name", "author or director", "2016", 6);
    }

    @Test
    public void should_check_out_a_valid_item_only_once() {
        assertTrue(item.checkOut());
        assertFalse(item.checkOut());
    }

    @Test
    public void should_return_a_valid_item_only_once(){
        item.checkOut();
        assertTrue(item.returnItem());
        assertFalse(item.returnItem());
    }

    @Test
    public void should_be_checked_out_again_after_return() {
        assertTrue(item.checkOut());
        assertTrue(item.returnItem());
        assertTrue(item.checkOut());
    }

    @Test
    public void should_not_check_out_a_invalid_book_or_movie() {
        assertFalse(Library.findItemByName("not exist", CHECK_OUT, BOOK_LIST));
        assertFalse(Library.findItemByName("not exist", CHECK_OUT, MOVIE_LIST));
    }

    @Test
    public void should_not_check_out_without_log_in(){

    }

    public static final boolean CHECK_OUT = true;
    public static final boolean RETURN_ITEM = false;
    public static final boolean BOOK_LIST = true;
    public static final boolean MOVIE_LIST = false;
}
