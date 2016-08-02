package com.twu.biblioteca;

import com.twu.biblioteca.Model.MainMenuMessage;
import com.twu.biblioteca.Model.User;
import com.twu.biblioteca.Router.RouterMessage;
import com.twu.biblioteca.Service.LibraryService;
import com.twu.biblioteca.Router.LibraryRouter;
import com.twu.biblioteca.Router.RouterState;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LibraryShellTest {

    @Test
    public void Should_display_welcome_message_when_current_state_is_Initializing(){
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.Initialize,new LibraryService());
        String actualResult = libraryRouter.getRouteMessage("").getText();
        String welcomMessage = "*****Welcom to TWU Library!*****\n\n";
        assertEquals(welcomMessage, actualResult);
    }

    @Test
    public void Should_display_main_menu_when_current_state_is_MainMenu(){
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.MainMenu,new LibraryService());
        String exceptResult = new MainMenuMessage().getMainMenu();
        RouterMessage routerMessage = libraryRouter.getRouteMessage(null);
        String actualResult = routerMessage.getText();
        assertEquals(exceptResult,actualResult);
        assertTrue(routerMessage.isWaitFroInput());
    }

    @Test
    public void Should_display_book_list_when_current_state_is_MainMenu_and_user_input_is_List_Books(){
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.MainMenu, new LibraryService());
        String expectResult = "Math,Jhon,1990-02-21\n"
                + "English,David,1889-09-20\n"
                + "History,Bob,1990-01-28\n";
        String actualResult = libraryRouter.getRouteMessage("1").getText();
        assertEquals(expectResult,actualResult);
    }

    @Test
    public void Should_display_invalid_message_when_user_input_is_not_List_Books_and_current_state_is_MainMenu(){
        String mainMenuText = new MainMenuMessage().getMainMenu();
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.MainMenu, new LibraryService());
        String actualResult = libraryRouter.getRouteMessage("59").getText();
        String expectResult = "Select a valid option!\n";
        assertEquals(expectResult, actualResult);
    }

    @Test
    public void Should_display_main_menu_when_user_input_is_not_list_book_and_current_state_is_MainMenu_and_user_continue_exeution(){
        String mainMenuText = new MainMenuMessage().getMainMenu();
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.MainMenu, new LibraryService());
        libraryRouter.getRouteMessage("59");
        String actualResult = libraryRouter.getRouteMessage(null).getText();
        assertEquals(mainMenuText,actualResult);
    }

    @Test
    public void Should_quit_when_user_input_is_Quit_and_current_state_is_MainMenu(){
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.MainMenu, new LibraryService());
        assertEquals(true, libraryRouter.getRouteMessage("0").isExit());
    }

    @Test
    public void Should_waiting_for_user_input_when_user_select_checkoutBook_and_current_status_is_mainmenu(){
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.MainMenu, new LibraryService());
        assertEquals(true, libraryRouter.getRouteMessage("2").isWaitFroInput());
    }

    @Test
    public void Should_return_books_without_checked_out_book_when_current_status_is_MainMenu_and_user_select_list_books(){
        LibraryService libraryService = new LibraryService();
        libraryService.checkoutBook("Math");
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.MainMenu, libraryService);
        String actualListBooks = libraryRouter.getRouteMessage("1").getText();
        String expectListBooks = "English,David,1889-09-20\n" + "History,Bob,1990-01-28\n";
        assertEquals(expectListBooks, actualListBooks);
    }

    @Test
    public void Should_dispaly_success_message_when_user_input_valid_book_name_and_current_status_is_checkoutBook(){
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.CheckoutBook, new LibraryService());
        String expectMessage = "Thank you! Enjoy the book.\n";
        String actualMessage = libraryRouter.getRouteMessage("Math").getText();
        assertEquals(expectMessage, actualMessage);
    }
    @Test
    public void Should_display_main_menu_message_when_user_input_valid_message_and_current_status_is_checkoutBooks_and_continue_execution(){
        String mainMenuMessage = new MainMenuMessage().getMainMenu();
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.CheckoutBook, new LibraryService());
        libraryRouter.getRouteMessage("Math");
        String actualMessage = libraryRouter.getRouteMessage(null).getText();
        assertEquals(mainMenuMessage, actualMessage);
    }

    @Test
    public void Should_dispaly_unsuccess_message_when_user_input_valid_book_name_and_current_status_is_checkoutBook(){
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.CheckoutBook, new LibraryService());
        String expectMessage = "That book is not available.\n";
        String actualMessage = libraryRouter.getRouteMessage("hehe").getText();
        assertEquals(expectMessage, actualMessage);
    }

    @Test
    public void Should_display_main_menu_message_when_user_input_Invalid_message_and_current_status_is_checkoutBooks_and_continue_execution(){
        String mainMenuMessage = new MainMenuMessage().getMainMenu();
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.CheckoutBook, new LibraryService());
        libraryRouter.getRouteMessage("hehe");
        String actualMessage = libraryRouter.getRouteMessage(null).getText();
        assertEquals(mainMenuMessage, actualMessage);
    }

    @Test
    public void Should_waiting_for_user_input_when_user_select_returnBook_and_current_status_is_mainmenu(){
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.MainMenu, new LibraryService());
        assertEquals(true, libraryRouter.getRouteMessage("3").isWaitFroInput());
    }

    @Test
    public void Should_dispaly_success_message_when_user_input_valid_book_name_and_current_status_is_returnBook(){
        LibraryService libraryService = new LibraryService();
        libraryService.setCurrentUser(new User("123-4567", "111"));
        libraryService.checkoutBook("Math");
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.Return, libraryService);
        String expectMessage = "Thank you for returning the book.\n";
        String actualMessage = libraryRouter.getRouteMessage("Math").getText();
        assertEquals(expectMessage, actualMessage);
    }

    @Test
    public void Should_display_main_menu_message_when_user_input_valid_message_and_current_status_is_returnBooks_and_continue_execution(){
        String mainMenuMessage = new MainMenuMessage().getMainMenu();
        LibraryService libraryService = new LibraryService();
        libraryService.setCurrentUser(new User("123-4567", "111"));
        libraryService.checkoutBook("Math");
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.Return, libraryService);
        libraryRouter.getRouteMessage("Math");
        String actualMessage = libraryRouter.getRouteMessage(null).getText();
        assertEquals(mainMenuMessage, actualMessage);
    }

    @Test
    public void Should_dispaly_unsuccess_message_when_user_input_valid_book_name_and_current_status_is_returnBook(){
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.Return, new LibraryService());
        String expectMessage = "That is not a valid book to return.\n";
        String actualMessage = libraryRouter.getRouteMessage("hehe").getText();
        assertEquals(expectMessage, actualMessage);
    }

    @Test
    public void Should_display_main_menu_message_when_user_input_Invalid_message_and_current_status_is_returnBooks_and_continue_execution(){
        String mainMenuMessage = new MainMenuMessage().getMainMenu();
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.Return, new LibraryService());
        libraryRouter.getRouteMessage("hehe");
        String actualMessage = libraryRouter.getRouteMessage(null).getText();
        assertEquals(mainMenuMessage, actualMessage);
    }
}
