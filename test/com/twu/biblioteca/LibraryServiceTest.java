package com.twu.biblioteca;


import com.twu.biblioteca.Service.LibraryService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryServiceTest {
    @Test
    public void Should_get_welcome_message_when_calling_getWelcomeMessage_method(){
        LibraryService libraryService = new LibraryService();
        String welcomMessage = libraryService.GetWelcomeMessage();
        String actualWelcomMessage = "*****Welcom to TWU Library!*****";
        assertEquals(actualWelcomMessage, welcomMessage);
    }

//    @Test
//    public void Should_list_all_books_names_when_calling_listBooks_method(){
//        LibraryService libraryService = new LibraryService();
//        libraryService.ListBooks();
//        String listResult = "Math\n" + "English\n" + "History\n";
//        assertEquals(listResult,outputStream.toString());
//    }

//    @Test
//    public void Should_list_all_books_with_name_author_published_year(){
//        LibraryService libraryService = new LibraryService();
//        String allBooks = libraryService.ListBooks();
//        String listDetailResult = "Math,Jhon,1990-02-21\n" + "English,David,1889-09-20\n" + "History,Bob,1990-01-28\n";
//        assertEquals(listDetailResult, allBooks);
//    }

    @Test
    public void Should_return_true_when_call_checkoutBook_if_the_book_has_not_checked_out_and_exists(){
        LibraryService libraryService = new LibraryService();
        boolean isChecked = libraryService.CheckoutBook("Math");
        assertEquals(true, isChecked);
    }

    @Test
    public void Should_return_false_when_call_checkoutBook_if_the_book_has_been_checked_or_not_exist(){
        LibraryService libraryService = new LibraryService();
        boolean isChecked = libraryService.CheckoutBook("hehe");
        assertEquals(false, isChecked);
    }

    @Test
    public void Should_return_books_that_are_not_checked_out_when_calling_listBooks(){
        LibraryService libraryService = new LibraryService();
        libraryService.CheckoutBook("Math");
        assertEquals(2, libraryService.ListBooks().size());
        assertEquals("English", libraryService.ListBooks().get(0).getBookName());
        assertEquals("History", libraryService.ListBooks().get(1).getBookName());
        libraryService.CheckoutBook("English");
        assertEquals("History",libraryService.ListBooks().get(0).getBookName());
    }
    @Test
    public void Should_return_true_when_call_returnBook_if_the_book_has_been_checked_out(){
        LibraryService libraryService = new LibraryService();
        libraryService.CheckoutBook("Math");
        boolean isReturned = libraryService.ReturnBook("Math");
        assertEquals(true, isReturned);
    }

    @Test
    public void Should_return_false_when_call_returnBook_if_the_book_has_been_checked_out(){
        LibraryService libraryService = new LibraryService();
        libraryService.CheckoutBook("Math");
        boolean isReturned = libraryService.ReturnBook("English");
        assertEquals(false, isReturned);
    }

    @Test
    public void Should_return_books_that_are_not_returned_when_calling_listBooks(){
        LibraryService libraryService = new LibraryService();
        libraryService.CheckoutBook("Math");
        assertEquals(2, libraryService.ListBooks().size());
        assertEquals("English", libraryService.ListBooks().get(0).getBookName());
        assertEquals("History", libraryService.ListBooks().get(1).getBookName());
        libraryService.ReturnBook("Math");
        assertEquals(3, libraryService.ListBooks().size());
        assertEquals("Math", libraryService.ListBooks().get(0).getBookName());
        assertEquals("English", libraryService.ListBooks().get(1).getBookName());
        assertEquals("History", libraryService.ListBooks().get(2).getBookName());
    }



}
