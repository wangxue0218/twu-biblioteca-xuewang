package com.twu.biblioteca.Shell;


import com.twu.biblioteca.Service.LibraryService;
import com.twu.biblioteca.Router.LibraryRouter;
import com.twu.biblioteca.Router.RouterMessage;
import com.twu.biblioteca.Router.RouterState;

public class LibraryShell {
    public void Execute()
    {
         LibraryRouter router = new LibraryRouter(RouterState.Initialize, new LibraryService());
         RouterMessage message = router.GetRouteMessage(null);
    }
}
