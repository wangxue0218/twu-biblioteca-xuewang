package com.twu.biblioteca;

import com.twu.biblioteca.Shell.LibraryShell;

import java.io.IOException;

public class BibliotecaApp {
    public static void main(String[] args) throws IOException {
        new LibraryShell(System.in, System.out).Execute();
    }
}
