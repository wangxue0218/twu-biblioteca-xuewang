package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class WelcomeMessageTest {
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

}
