package com.twu.biblioteca.Router.ActionHandler;

import com.twu.biblioteca.Router.RouterMessage;

public interface IActionHandler {
    RouterMessage handle(String userInput);
}
