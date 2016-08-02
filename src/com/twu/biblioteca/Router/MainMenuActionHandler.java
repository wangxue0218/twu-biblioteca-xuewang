package com.twu.biblioteca.Router;

import com.twu.biblioteca.Model.MainMenuMessage;
import com.twu.biblioteca.Model.Movie;
import com.twu.biblioteca.Service.LibraryService;
import com.twu.biblioteca.Model.Book;

import java.util.ArrayList;

/**
 * Created by xuewang on 8/1/16.
 */
public class MainMenuActionHandler implements IActionHandler {
    RouterContext m_routerContext;
    LibraryService m_libraryService;
    private static String MainMenuText = new MainMenuMessage().getMainMenu();

    public MainMenuActionHandler(RouterContext routerContext, LibraryService libraryService)
    {
        m_routerContext = routerContext;
        m_libraryService = libraryService;
    }

    public String getBookDetails(){
        ArrayList<Book> unCheckBook = m_libraryService.ListBooks();
        String booksDetails = "";
        for(int i=0; i<unCheckBook.size(); i++){
            booksDetails += (unCheckBook.get(i).getBookName() + "," + unCheckBook.get(i).getBookAuthor() + "," + unCheckBook.get(i).getBookYear() + "\n");
        }
        return booksDetails;
    }

    public String getMovieDetails(){
        ArrayList<Movie> movies = m_libraryService.listMovies();
        String moviesDetails = "";
        for(int i=0; i<movies.size(); i++){
            moviesDetails += (movies.get(i).getMovieName()+","+movies.get(i).getMovieYear()+","+movies.get(i).getMovieDirector()+","+movies.get(i).getMovieRating()+"\n");
        }
        return moviesDetails;
    }

    @Override
    public RouterMessage handle(String userInput)
    {
        if (userInput == null) {
            return new RouterMessage(false, MainMenuText, true);
        }
        if (userInput.equals("1")) {
            return new RouterMessage(false, getBookDetails(), false);
        }
        if(userInput.equals("2")){
            m_routerContext.setNextState(RouterState.CheckOut);
            return new RouterMessage(false, "", true);
        }
        if(userInput.equals("3")){
            m_routerContext.setNextState(RouterState.Return);
            return new RouterMessage(false, "", true);
        }
        if(userInput.equals("0")){
            return new RouterMessage(true, "", false);
        }
        if(userInput.equals("4")){
            return new RouterMessage(false, getMovieDetails(), false);
        }
        return new RouterMessage(false, "Select a valid option!\n", false);
    }
}
