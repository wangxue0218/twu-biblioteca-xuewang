package com.twu.biblioteca;

import java.util.ArrayList;

public class LibraryService {
    private ArrayList<Book> allBooks = new ArrayList<Book>(){
        {
            add(new Book("Math", "Jhon", "1990-02-21"));
            add(new Book("English", "David", "1889-09-20"));
            add(new Book("History", "Bob", "1990-01-28"));
        }
    };

    public String GetWelcomeMessage(){

        String welcomeMessage = "*****Welcom to TWU Library!*****";
        return welcomeMessage;
    }

    public String ListBooks(){
        String booksDetails = "";
        for(int i=0; i<allBooks.size(); i++){
            booksDetails += (allBooks.get(i).getBookName() + "," + allBooks.get(i).getBookAuthor() + "," + allBooks.get(i).getBookYear() + "\n");
        }
        return booksDetails;
    }
}
