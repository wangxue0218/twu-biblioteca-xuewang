package com.twu.biblioteca.Router;

import com.twu.biblioteca.Service.LibraryService;

/**
 * Created by xuewang on 8/1/16.
 */
public class CheckoutActionHandler implements IActionHandler {
    RouterContext m_routerContext;
    LibraryService m_libraryService;

    public CheckoutActionHandler(RouterContext routerContext, LibraryService libraryService)
    {
        m_routerContext = routerContext;
        m_libraryService = libraryService;
    }
    @Override
    public RouterMessage Handle(String userInput) {
        String mainMenuText = "********MainMenu************\n"
                + "****************************\n"
                + "1. List Books\n"
                + "2. Checkout Books\n"
                + "3. Return Books\n"
                + "4. Quit\n";
        boolean checkoutSuccess = m_libraryService.CheckoutBook(userInput);
        m_routerContext.SetNextState(RouterState.MainMenu);
        if (checkoutSuccess)
        {
            return new RouterMessage(false, "Thank you! Enjoy the book.\n" + mainMenuText, false);
        }
        return new RouterMessage(false, "That book is not available.\n" + mainMenuText, false);
    }
}
