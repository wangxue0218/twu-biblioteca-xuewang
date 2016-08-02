package com.twu.biblioteca.Router.ActionHandler;

import com.twu.biblioteca.Router.RouterMessage;

/**
 * Created by xuewang on 8/1/16.
 */
public interface IActionHandler {
    RouterMessage handle(String userInput);
}
