package com.twu.biblioteca.Router.ActionHandler;

import com.twu.biblioteca.Resource.DataResource;
import com.twu.biblioteca.Model.Movie;
import com.twu.biblioteca.Model.User;
import com.twu.biblioteca.Router.RouterContext;
import com.twu.biblioteca.Router.RouterMessage;
import com.twu.biblioteca.Router.RouterState;
import com.twu.biblioteca.Service.LibraryService;
import com.twu.biblioteca.Model.Book;

import java.util.ArrayList;

public class MainMenuActionHandler implements IActionHandler {
    private RouterContext m_routerContext;
    private LibraryService m_libraryService;
    private static String MainMenuText = new DataResource().getMainMenu();

    public MainMenuActionHandler(RouterContext routerContext, LibraryService libraryService)
    {
        m_routerContext = routerContext;
        m_libraryService = libraryService;
    }

    private String getBookDetails(){
        ArrayList<Book> unCheckBook = m_libraryService.ListBooks();
        String booksDetails = "";
        for (Book anUnCheckBook : unCheckBook) {
            booksDetails += (anUnCheckBook.getBookName() + "," + anUnCheckBook.getBookAuthor() + "," + anUnCheckBook.getBookYear() + "\n");
        }
        return booksDetails;
    }

    private String getMovieDetails(){
        ArrayList<Movie> movies = m_libraryService.listMovies();
        String moviesDetails = "";
        for (Movie movie : movies) {
            moviesDetails += (movie.getMovieName() + "," + movie.getMovieYear() + "," + movie.getMovieDirector() + "," + movie.getMovieRating() + "\n");
        }
        return moviesDetails;
    }

    private String getUserInformation(){
        User currentUser = m_libraryService.getUserInformation();
        return currentUser.getUserName()+","+currentUser.getUserAdress()+","+currentUser.getPhoneNumber()+"\n";
    }

    @Override
    public RouterMessage handle(String userInput)
    {
        String remindLoginMessage = "LogIn :Please input your library number and passward, and split with ','\n";
        if (userInput == null) {
            boolean isLogin = m_libraryService.getCurrentUser().getIsLogin();
            if(isLogin){
                String newMainMenu = new DataResource().getMainMenu() + "7. UserInformation\n";
                return new RouterMessage(false, newMainMenu, true);
            }
            return new RouterMessage(false, MainMenuText, true);
        }
        if(userInput.equals("0")){
            return new RouterMessage(true, "", false);
        }
        if (userInput.equals("1")) {
            return new RouterMessage(false, getBookDetails(), false);
        }
        if(userInput.equals("2")){
            boolean isLogin = m_libraryService.getCurrentUser().getIsLogin();
            if(!isLogin){
                m_routerContext.setNextState(RouterState.LogIn);
                return new RouterMessage(false, remindLoginMessage, true);
            }
            m_routerContext.setNextState(RouterState.CheckoutBook);
            return new RouterMessage(false, "", true);
        }
        if(userInput.equals("3")){
            boolean isLogin = m_libraryService.getCurrentUser().getIsLogin();
            if(!isLogin){
                m_routerContext.setNextState(RouterState.LogIn);
                return new RouterMessage(false, remindLoginMessage, true);
            }
            m_routerContext.setNextState(RouterState.Return);
            return new RouterMessage(false, "", true);
        }
        if(userInput.equals("4")){
            return new RouterMessage(false, getMovieDetails(), false);
        }
        if(userInput.equals("5")){
            boolean isLogin = m_libraryService.getCurrentUser().getIsLogin();
            if(!isLogin){
                m_routerContext.setNextState(RouterState.LogIn);
                return new RouterMessage(false, remindLoginMessage, true);
            }
            m_routerContext.setNextState(RouterState.CheckoutMovie);
            return new RouterMessage(false, "", true);
        }
        if(userInput.equals("6")){
            boolean curUserIsLogin = m_libraryService.getCurrentUser().getIsLogin();
            if(curUserIsLogin){
                return new RouterMessage(false, "You are LogIn,try another option\n",false);
            }
            m_routerContext.setNextState(RouterState.LogIn);
            return new RouterMessage(false, remindLoginMessage, true);
        }
        if(userInput.equals("7")){
            return new RouterMessage(false, getUserInformation(), false);
        }
        return new RouterMessage(false, "Select a valid option!\n", false);
    }
}
