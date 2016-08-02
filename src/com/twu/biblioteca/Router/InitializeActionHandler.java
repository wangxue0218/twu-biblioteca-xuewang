package com.twu.biblioteca.Router;

import com.twu.biblioteca.Service.LibraryService;

/**
 * Created by xuewang on 8/1/16.
 */
public class InitializeActionHandler implements IActionHandler {
    RouterContext m_routerContext;
    LibraryService m_libraryService;

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
