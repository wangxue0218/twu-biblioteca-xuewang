package com.twu.biblioteca.Router.ActionHandler;

import com.twu.biblioteca.Router.ActionHandler.IActionHandler;
import com.twu.biblioteca.Router.RouterContext;
import com.twu.biblioteca.Router.RouterMessage;
import com.twu.biblioteca.Router.RouterState;
import com.twu.biblioteca.Service.LibraryService;

/**
 * Created by xuewang on 8/1/16.
 */
public class ReturnActionHandler implements IActionHandler {
    RouterContext m_routerContext;
    LibraryService m_libraryService;

    public ReturnActionHandler(RouterContext routerContext, LibraryService libraryService)
    {
        m_routerContext = routerContext;
        m_libraryService = libraryService;
    }
    @Override
    public RouterMessage handle(String userInput) {
        boolean returnSuccess = m_libraryService.returnBook(userInput);
        m_routerContext.setNextState(RouterState.MainMenu);
        if (returnSuccess) {
            return new RouterMessage(false, "Thank you for returning the book.\n", false);
        }
        return new RouterMessage(false, "That is not a valid book to return.\n", false);
    }
}
