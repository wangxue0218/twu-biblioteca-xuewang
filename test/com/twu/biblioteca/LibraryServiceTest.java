package com.twu.biblioteca;


import com.twu.biblioteca.Model.User;
import com.twu.biblioteca.Service.LibraryService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryServiceTest {
    @Test
    public void Should_get_welcome_message_when_calling_getWelcomeMessage_method(){
        LibraryService libraryService = new LibraryService();
        String welcomMessage = libraryService.getWelcomeMessage();
        String actualWelcomMessage = "*****Welcom to TWU Library!*****\n\n";

        assertEquals(actualWelcomMessage, welcomMessage);
    }

    @Test
    public void Should_list_all_books_with_name_author_published_year(){
        LibraryService libraryService = new LibraryService();

        assertEquals("Math", libraryService.ListBooks().get(0).getBookName());
        assertEquals("Jhon", libraryService.ListBooks().get(0).getBookAuthor());
        assertEquals("1990-02-21", libraryService.ListBooks().get(0).getBookYear());
    }

    @Test
    public void Should_return_true_when_call_checkoutBook_if_the_book_has_not_checked_out_and_exists(){
        LibraryService libraryService = new LibraryService();
        boolean isChecked = libraryService.checkoutBook("Math");
        assertEquals(true, isChecked);
    }

    @Test
    public void Should_return_false_when_call_checkoutBook_if_the_book_has_been_checked_or_not_exist(){
        LibraryService libraryService = new LibraryService();
        boolean isChecked = libraryService.checkoutBook("hehe");
        assertEquals(false, isChecked);
    }

    @Test
    public void Should_return_books_that_are_not_checked_out_when_calling_listBooks(){
        LibraryService libraryService = new LibraryService();
        libraryService.checkoutBook("Math");
        assertEquals(2, libraryService.ListBooks().size());
        assertEquals("English", libraryService.ListBooks().get(0).getBookName());
        assertEquals("History", libraryService.ListBooks().get(1).getBookName());
        libraryService.checkoutBook("English");
        assertEquals("History",libraryService.ListBooks().get(0).getBookName());
    }
    @Test
    public void Should_return_true_when_call_returnBook_if_the_book_has_been_checked_out(){
        LibraryService libraryService = new LibraryService();
        libraryService.setCurrentUser(new User("123-4567", "111"));
        libraryService.checkoutBook("Math");
        boolean isReturned = libraryService.returnBook("Math");
        assertEquals(true, isReturned);
    }

    @Test
    public void Should_return_false_when_call_returnBook_if_the_book_has_been_checked_out(){
        LibraryService libraryService = new LibraryService();
        libraryService.checkoutBook("Math");
        boolean isReturned = libraryService.returnBook("English");
        assertEquals(false, isReturned);
    }

    @Test
    public void Should_return_books_that_are_not_returned_when_calling_listBooks(){
        LibraryService libraryService = new LibraryService();
        libraryService.setCurrentUser(new User("123-4567", "111"));
        libraryService.checkoutBook("Math");
        assertEquals(2, libraryService.ListBooks().size());
        assertEquals("English", libraryService.ListBooks().get(0).getBookName());
        assertEquals("History", libraryService.ListBooks().get(1).getBookName());
        libraryService.returnBook("Math");
        assertEquals(3, libraryService.ListBooks().size());
        assertEquals("Math", libraryService.ListBooks().get(0).getBookName());
        assertEquals("English", libraryService.ListBooks().get(1).getBookName());
        assertEquals("History", libraryService.ListBooks().get(2).getBookName());
    }
}
