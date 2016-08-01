package com.twu.biblioteca.Router;


import com.twu.biblioteca.Service.LibraryService;

public class LibraryRouter {

    RouterContext m_routerContext;
    LibraryService m_libraryService;

    public LibraryRouter(RouterState routerState, LibraryService libraryService){
        m_libraryService = libraryService;
        m_routerContext = new RouterContext(routerState);
    }

    public RouterMessage GetRouteMessage(String userInput){
        return GetActionHandler().Handle(userInput);

    }
    IActionHandler GetActionHandler()
    {
        switch (m_routerContext.GetCurrentState())
        {
            case Initialize:
                return new InitializeActionHandler(m_routerContext, m_libraryService);
            case MainMenu:
                return new MainMenuActionHandler(m_routerContext, m_libraryService);
            case CheckOut:
                return new CheckoutActionHandler(m_routerContext, m_libraryService);
            default:
                return null;
        }
    }
}
