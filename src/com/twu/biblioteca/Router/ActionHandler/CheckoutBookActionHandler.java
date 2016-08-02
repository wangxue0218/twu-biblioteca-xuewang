package com.twu.biblioteca.Router.ActionHandler;

import com.twu.biblioteca.Router.RouterContext;
import com.twu.biblioteca.Router.RouterMessage;
import com.twu.biblioteca.Router.RouterState;
import com.twu.biblioteca.Service.LibraryService;


public class CheckoutBookActionHandler implements IActionHandler {
    RouterContext m_routerContext;
    LibraryService m_libraryService;

    public CheckoutBookActionHandler(RouterContext routerContext, LibraryService libraryService)
    {
        m_routerContext = routerContext;
        m_libraryService = libraryService;
    }
    @Override
    public RouterMessage handle(String userInput) {
        boolean checkoutSuccess = m_libraryService.checkoutBook(userInput);
        m_routerContext.setNextState(RouterState.MainMenu);
        if (checkoutSuccess)
        {
            return new RouterMessage(false, "Thank you! Enjoy the book.\n", false);
        }
        return new RouterMessage(false, "That book is not available.\n", false);
    }
}
