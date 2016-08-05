package com.twu.biblioteca.Router.ActionHandler;

import com.twu.biblioteca.Router.RouterContext;
import com.twu.biblioteca.Router.RouterMessage;
import com.twu.biblioteca.Router.RouterState;
import com.twu.biblioteca.Service.LibraryService;


public class LogInActionHandler implements IActionHandler{
    private RouterContext m_routerContext;
    private LibraryService m_libraryService;

    public LogInActionHandler(RouterContext routerContext, LibraryService libraryService) {
        m_routerContext = routerContext;
        m_libraryService = libraryService;
    }

    @Override
    public RouterMessage handle(String userInput) {
        boolean isLogIn = m_libraryService.isLogIn(userInput);
        m_routerContext.setNextState(RouterState.MainMenu);
        if (isLogIn)
        {
            return new RouterMessage(false, "successfully log in\n", false);
        }
        return new RouterMessage(false, "library number or passward is wrong, please try again\n", false);
    }
}
