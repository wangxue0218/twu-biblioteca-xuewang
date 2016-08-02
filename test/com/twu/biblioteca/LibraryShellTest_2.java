package com.twu.biblioteca;

import com.twu.biblioteca.Model.MainMenuMessage;
import com.twu.biblioteca.Router.LibraryRouter;
import com.twu.biblioteca.Router.RouterState;
import com.twu.biblioteca.Service.LibraryService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by xuewang on 8/2/16.
 */
public class LibraryShellTest_2 {

    @Test
    public void should_dispaly_all_available_movies_when_current_status_is_MainMenu_and_user_select_ListMovies(){
        LibraryRouter libraryRouter = new LibraryRouter(RouterState.MainMenu, new LibraryService());
        String expectResult = "Titanic,1997,wangxue,9\n" + "Movie2,1990,xuewang,8\n";
        String actualResult = libraryRouter.GetRouteMessage("4").getText();
        assertEquals(expectResult,actualResult);
    }

    
}
