package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class LibraryServiceTest {
    private PrintStream console = null;
    private ByteArrayOutputStream outputStream = null;

    @Before
    public void setUp() throws Exception {
        outputStream = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(console);
    }

    @Test
    public void Should_get_welcome_message_when_calling_getWelcomeMessage_method(){
        LibraryService libraryService = new LibraryService();
        libraryService.GetWelcomeMessage();
        String welcomMessage = "*****Welcom to TWU Library!*****";
        assertEquals(welcomMessage, outputStream.toString());
    }

    @Test
    public void Should_list_all_books_names_when_calling_listBooks_method(){
        LibraryService libraryService = new LibraryService();
        libraryService.ListBooks();
        String listResult = "Math\n" + "English\n" + "History\n";
        assertEquals(listResult,outputStream.toString());
    }

}
