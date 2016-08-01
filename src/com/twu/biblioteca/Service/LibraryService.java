package com.twu.biblioteca.Service;

import com.twu.biblioteca.Book;

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

    public ArrayList<Book> ListBooks(){
        ArrayList<Book> unCheckBookList = new ArrayList<Book>();
        for(int i=0; i<allBooks.size(); i++){
            if(allBooks.get(i).getStatus() == false)
                unCheckBookList.add(allBooks.get(i));
        }
        return unCheckBookList;
    }
    public boolean CheckoutBook(String name){
        int i;
        for(i=0; i<allBooks.size(); i++){
            if(allBooks.get(i).getBookName().equals(name)&& !allBooks.get(i).getStatus()){
                allBooks.get(i).setStatus(true);
                break;
            }
        }
        if(i == allBooks.size())
            return false;
        return true;
    }

}
