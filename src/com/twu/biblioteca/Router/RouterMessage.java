package com.twu.biblioteca.Router;

public class RouterMessage
{
    boolean Exit;
    String Text;
    boolean WaitForInput;

    public RouterMessage(boolean exit, String text, boolean waitForInput)
    {
        Exit = exit;
        Text = text;
        WaitForInput = waitForInput;
    }

    public boolean isExit() {
        return Exit;
    }

    public String getText() {
        return Text;
    }


    public boolean isWaitFroInput() {
        return WaitForInput;
    }

}