package com.twu.biblioteca.Router.ActionHandler;

import com.twu.biblioteca.Router.ActionHandler.IActionHandler;
import com.twu.biblioteca.Router.RouterContext;
import com.twu.biblioteca.Router.RouterMessage;
import com.twu.biblioteca.Router.RouterState;
import com.twu.biblioteca.Service.LibraryService;

/**
 * Created by xuewang on 8/1/16.
 */
public class InitializeActionHandler implements IActionHandler {
    private RouterContext m_routerContext;
    private LibraryService m_libraryService;

    public InitializeActionHandler(RouterContext routerContext, LibraryService libraryService) {
        m_libraryService = libraryService;
        m_routerContext = routerContext;
    }

    @Override
    public RouterMessage handle(String userInput) {
        String welcomeMessage = m_libraryService.getWelcomeMessage();
        m_routerContext.setNextState(RouterState.MainMenu);
        return new RouterMessage(false, welcomeMessage, false);
    }
}
