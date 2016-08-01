package com.twu.biblioteca;

/**
 * Created by xuewang on 8/1/16.
 */
public class InitializeActionHandler implements IActionHandler{
    RouterContext m_routerContext;
    LibraryService m_libraryService;

    public InitializeActionHandler(RouterContext routerContext, LibraryService libraryService) {
        m_libraryService = libraryService;
        m_routerContext = routerContext;
    }

    @Override
    public RouterMessage Handle(String userInput) {
        String welcomeMessage = m_libraryService.GetWelcomeMessage();
        m_routerContext.SetNextState(RouterState.MainMenu);
        return new RouterMessage(false, welcomeMessage);
    }
}
