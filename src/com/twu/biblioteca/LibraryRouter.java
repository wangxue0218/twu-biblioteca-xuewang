package com.twu.biblioteca;

/**
 * Created by xuewang on 8/1/16.
 */
public class LibraryRouter {
    RouterState m_routerState;
    LibraryService m_libraryService;

    public LibraryRouter(RouterState routerState,LibraryService libraryService){
        m_libraryService = libraryService;
        m_routerState = routerState;
    }

    public void RouteMessage(){
        if(m_routerState.equals(RouterState.Initialize)){
            m_libraryService.GetWelcomeMessage();
        }
    }
}
