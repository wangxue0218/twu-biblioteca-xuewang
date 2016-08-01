package com.twu.biblioteca;


public class LibraryShell {
    public void Execute()
    {
         LibraryRouter router = new LibraryRouter(RouterState.Initialize, new LibraryService());
         router.RouteMessage();
    }
}
