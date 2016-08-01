package com.twu.biblioteca;

import com.twu.biblioteca.Service.LibraryService;
import com.twu.biblioteca.Router.LibraryRouter;
import com.twu.biblioteca.Router.RouterState;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class LibraryShellTest {

    @Test
    public void Should_display_welcome_message_when_current_state_is_Initializing(){
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.Initialize,new LibraryService());
        String actualResult = libraryRouter.GetRouteMessage("").getText();
        String welcomMessage = "*****Welcom to TWU Library!*****";
        assertEquals(welcomMessage, actualResult);
    }

    @Test
    public void Should_display_main_menu_when_current_state_is_MainMenu(){
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.MainMenu,new LibraryService());
        String exceptResult = "********MainMenu************\n"
                            + "****************************\n"
                            + "1. List Books\n";
        String actualResult = libraryRouter.GetRouteMessage("").getText();
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
        String actualResult = libraryRouter.GetRouteMessage("1").getText();
        assertEquals(expectResult,actualResult);
    }

    @Test
    public void Should_display_invalid_message_when_user_input_is_not_List_Books_and_current_state_is_MainMenu(){
        String mainMenuText = "********MainMenu************\n"
                + "****************************\n"
                + "1. List Books\n";
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.MainMenu, new LibraryService());
        String actualResult = libraryRouter.GetRouteMessage("3").getText();
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
        String actualResult = libraryRouter.GetRouteMessage("").getText();
        assertEquals(mainMenuText,actualResult);
    }

    @Test
    public void Should_quit_when_user_input_is_Quit_and_current_state_is_MainMenu(){
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.MainMenu, new LibraryService());
        assertEquals(true, libraryRouter.GetRouteMessage("4").isExit());
    }

    @Test
    public void Should_waiting_for_user_input_when_user_select_checkoutBook_and_current_status_is_mainmenu(){
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.MainMenu, new LibraryService());
        assertEquals(true, libraryRouter.GetRouteMessage("2").isWaitFroInput());
    }

    
}
