package com.twu.biblioteca;

public class RouterMessage
{
    public RouterMessage(boolean exit, String text)
    {
        Exit = exit;
        Text = text;
    }

    boolean Exit;
    String Text;
}