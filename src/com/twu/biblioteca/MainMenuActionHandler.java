package com.twu.biblioteca;

/**
 * Created by xuewang on 8/1/16.
 */
public class MainMenuActionHandler implements IActionHandler{
    RouterContext m_routerContext;
    LibraryService m_libraryService;
    private static String MainMenuText = "********MainMenu************\n"
            + "****************************\n"
            + "1. List Books\n";

    public MainMenuActionHandler(RouterContext routerContext, LibraryService libraryService)
    {
        m_routerContext = routerContext;
        m_libraryService = libraryService;
    }

    @Override
    public RouterMessage Handle(String userInput)
    {
        if (userInput.equals("")) {
            return new RouterMessage(false, MainMenuText);
        } else if (userInput.equals("1")) {
            String booksDetials = m_libraryService.ListBooks();
            return new RouterMessage(
                    false, booksDetials + MainMenuText);
        } else {
            return new RouterMessage(
                    false,
                    "Select a valid option!\n" + MainMenuText);
        }
    }
}
