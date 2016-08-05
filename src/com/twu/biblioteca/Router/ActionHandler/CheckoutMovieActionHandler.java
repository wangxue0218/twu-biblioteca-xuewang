package com.twu.biblioteca.Router.ActionHandler;

import com.twu.biblioteca.Router.RouterContext;
import com.twu.biblioteca.Router.RouterMessage;
import com.twu.biblioteca.Router.RouterState;
import com.twu.biblioteca.Service.LibraryService;


public class CheckoutMovieActionHandler implements IActionHandler {
    private RouterContext m_routerContext;
    private LibraryService m_libraryService;

    public CheckoutMovieActionHandler(RouterContext routerContext, LibraryService libraryService)
    {
        m_routerContext = routerContext;
        m_libraryService = libraryService;
    }
    @Override
    public RouterMessage handle(String userInput) {
        boolean checkoutSuccess = m_libraryService.checkoutBook(userInput);
        m_routerContext.setNextState(RouterState.MainMenu);
        return new RouterMessage(false, "", false);
    }
}
