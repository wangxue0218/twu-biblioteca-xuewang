package com.twu.biblioteca.Resource;

import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.Movie;
import com.twu.biblioteca.Model.User;

import java.util.ArrayList;

public class DataResource {

    public String getMainMenu(){
        return "********MainMenu************\n"
                + "****************************\n"
                + "0. Quit\n"
                + "1. List Books\n"
                + "2. Checkout Books\n"
                + "3. Return Books\n"
                + "4. List Movies\n"
                + "5. Checkout Movies\n"
                + "6. Log In\n";
    }

    public ArrayList<Book> getAllBooks(){
        return new ArrayList<Book>(){
            {
                add(new Book("Math", "Jhon", "1990-02-21"));
                add(new Book("English", "David", "1889-09-20"));
                add(new Book("History", "Bob", "1990-01-28"));
            }
        };

    }

    public ArrayList<Movie> getAllMovies() {
        return new ArrayList<Movie>() {
            {
                add(new Movie("Titanic", "1997", "wangxue", 9));
                add(new Movie("Movie2", "1990", "xuewang", 8));
            }
        };
    }

    public ArrayList<User> getAllUsers(){
        return new ArrayList<User>(){
            {
                add(new User("123-4567", "111", false, "xue", "henan", "123456"));
                add(new User("000-5678", "222", false, "xuexue", "henan", "123456"));
            }
        };
    }
}
