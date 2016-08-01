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

    public void GetWelcomeMessage(){
        System.out.print("*****Welcom to TWU Library!*****");
    }

    public void ListBooks(){
        for(int i=0; i<allBooks.size(); i++){
            System.out.println(allBooks.get(i).getBookName());
        }
    }
}
