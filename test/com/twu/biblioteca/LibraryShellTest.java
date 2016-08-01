package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class LibraryShellTest {
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
    public void Should_display_welcome_message_when_current_state_is_Initializing(){
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.Initialize,new LibraryService());
        String actualResult = libraryRouter.GetRouteMessage("").Text;
        String welcomMessage = "*****Welcom to TWU Library!*****";
        assertEquals(welcomMessage, actualResult);
    }

    @Test
    public void Should_display_main_menu_when_current_state_is_MainMenu(){
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.MainMenu,new LibraryService());
        String exceptResult = "********MainMenu************\n"
                            + "****************************\n"
                            + "1. List Books\n";
        String actualResult = libraryRouter.GetRouteMessage("").Text;
        assertEquals(exceptResult,actualResult);
    }

    @Test
    public void Should_display_book_list_when_current_state_is_MainMenu_and_user_input_is_List_Books(){
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.MainMenu, new LibraryService());
        String expectResult = "Math,Jhon,1990-02-21\n"
                + "English,David,1889-09-20\n"
                + "History,Bob,1990-01-28\n"
                + "********MainMenu************\n"
                + "****************************\n"
                + "1. List Books\n";
        String actualResult = libraryRouter.GetRouteMessage("1").Text;
        assertEquals(expectResult,actualResult);
    }

    @Test
    public void Should_display_invalid_message_when_user_input_is_not_List_Books_and_current_state_is_MainMenu(){
        String mainMenuText = "********MainMenu************\n"
                + "****************************\n"
                + "1. List Books\n";
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.MainMenu, new LibraryService());
        String actualResult = libraryRouter.GetRouteMessage("3").Text;
        String expectResult = "Select a valid option!\n" + mainMenuText;
        assertEquals(expectResult, actualResult);
    }

    @Test
    public void Should_display_main_menu_when_user_input_is_not_list_book_and_current_state_is_MainMenu_and_user_continue_exeution(){
        String mainMenuText = "********MainMenu************\n"
                + "****************************\n"
                + "1. List Books\n";
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.MainMenu, new LibraryService());
        libraryRouter.GetRouteMessage("3");
        String actualResult = libraryRouter.GetRouteMessage("").Text;
        assertEquals(mainMenuText,actualResult);
    }

    
}
