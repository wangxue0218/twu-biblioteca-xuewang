package com.twu.biblioteca.Router;

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
    public RouterMessage Handle(String userInput) {
        boolean returnSuccess = m_libraryService.ReturnBook(userInput);
        m_routerContext.SetNextState(RouterState.MainMenu);
        if (returnSuccess) {
            return new RouterMessage(false, "Thank you for returning the book.\n", false);
        }
        return new RouterMessage(false, "That is not a valid book to return.\n", false);
    }
}
