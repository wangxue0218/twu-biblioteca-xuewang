package com.twu.biblioteca.Router;


import com.twu.biblioteca.Router.ActionHandler.*;
import com.twu.biblioteca.Service.LibraryService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class LibraryRouter {

    private RouterContext m_routerContext;
    private LibraryService m_libraryService;

    public LibraryRouter(RouterState routerState, LibraryService libraryService){
        m_libraryService = libraryService;
        m_routerContext = new RouterContext(routerState);
    }

    public RouterMessage getRouteMessage(String userInput){
        return getActionHandler().handle(userInput);

    }
    private IActionHandler getActionHandler()
    {
        switch (m_routerContext.getCurrentState())
        {
            case Initialize:
                return new InitializeActionHandler(m_routerContext, m_libraryService);
            case MainMenu:
                return new MainMenuActionHandler(m_routerContext, m_libraryService);
            case CheckoutBook:
                return new CheckoutBookActionHandler(m_routerContext, m_libraryService);
            case CheckoutMovie:
                return new CheckoutMovieActionHandler(m_routerContext, m_libraryService);
            case Return:
                return new ReturnActionHandler(m_routerContext, m_libraryService);
            case LogIn:
                return new LogInActionHandler(m_routerContext, m_libraryService);
            default:
                throw new NotImplementedException();
        }
    }
}
