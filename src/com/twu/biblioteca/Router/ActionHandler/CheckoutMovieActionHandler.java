package com.twu.biblioteca.Router.ActionHandler;

import com.twu.biblioteca.Router.RouterContext;
import com.twu.biblioteca.Router.RouterMessage;
import com.twu.biblioteca.Router.RouterState;
import com.twu.biblioteca.Service.LibraryService;

/**
 * Created by xuewang on 8/2/16.
 */
public class CheckoutMovieActionHandler implements IActionHandler {
    RouterContext m_routerContext;
    LibraryService m_libraryService;

    public CheckoutMovieActionHandler(RouterContext routerContext, LibraryService libraryService)
    {
        m_routerContext = routerContext;
        m_libraryService = libraryService;
    }
    @Override
    public RouterMessage handle(String userInput) {
        boolean checkoutSuccess = m_libraryService.checkoutBook(userInput);
        m_routerContext.setNextState(RouterState.MainMenu);
        return new RouterMessage(false, null, false);
    }
}
