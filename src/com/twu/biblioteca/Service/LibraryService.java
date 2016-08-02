package com.twu.biblioteca.Service;

import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.Movie;

import java.util.ArrayList;

public class LibraryService {
    private ArrayList<Book> allBooks = new ArrayList<Book>(){
        {
            add(new Book("Math", "Jhon", "1990-02-21"));
            add(new Book("English", "David", "1889-09-20"));
            add(new Book("History", "Bob", "1990-01-28"));
        }
    };
    protected ArrayList<Movie> allMovies = new ArrayList<Movie>(){
        {
            add(new Movie("Titanic", "1997", "wangxue", 9));
            add(new Movie("Movie2", "1990", "xuewang", 8));

        }
    };

    public String getWelcomeMessage(){

        String welcomeMessage = "*****Welcom to TWU Library!*****\n\n";
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

    public ArrayList<Movie> listMovies(){
        return allMovies;
    }

    public boolean checkoutBook(String name){
        if(name == null || name.isEmpty()){
            return false;
        }
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

    public boolean returnBook(String name){
        int i;
        for(i=0; i<allBooks.size(); i++){
            if(allBooks.get(i).getBookName().equals(name)&& allBooks.get(i).getStatus()){
                allBooks.get(i).setStatus(false);
                break;
            }
        }
        if(i == allBooks.size())
            return false;
        return true;
    }

}
