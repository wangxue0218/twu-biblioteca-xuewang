package com.twu.biblioteca.Shell;


import com.twu.biblioteca.Service.LibraryService;
import com.twu.biblioteca.Router.LibraryRouter;
import com.twu.biblioteca.Router.RouterMessage;
import com.twu.biblioteca.Router.RouterState;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class LibraryShell {
    OutputStream m_outputStream;
    InputStream m_inputStream;

    public LibraryShell(InputStream inputStream, OutputStream outputStream)
    {
        m_outputStream = outputStream;
        m_inputStream = inputStream;
    }
    public void Execute() throws IOException {

        LibraryRouter router = new LibraryRouter(RouterState.Initialize, new LibraryService());
        String userInput = null;
        while (true)
        {
            RouterMessage message = router.GetRouteMessage(userInput);
            m_outputStream.write(message.getText().getBytes());
            if (message.isExit()) { break; }
            if(message.isWaitFroInput()){
                userInput = new Scanner(m_inputStream).next();
            }else {
                userInput = null;
            }

        }
    }
}
