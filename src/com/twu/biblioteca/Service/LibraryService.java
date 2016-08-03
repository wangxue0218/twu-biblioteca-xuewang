package com.twu.biblioteca.Service;

import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.Movie;
import com.twu.biblioteca.Model.User;

import java.util.ArrayList;

public class LibraryService {
    private ArrayList<Book> allBooks = new ArrayList<Book>(){
        {
            add(new Book("Math", "Jhon", "1990-02-21"));
            add(new Book("English", "David", "1889-09-20"));
            add(new Book("History", "Bob", "1990-01-28"));
        }
    };

    private ArrayList<Movie> allMovies = new ArrayList<Movie>(){
        {
            add(new Movie("Titanic", "1997", "wangxue", 9));
            add(new Movie("Movie2", "1990", "xuewang", 8));

        }
    };

    private ArrayList<User> allUsers = new ArrayList<User>(){
        {
            add(new User("123-4567", "111", false, "xue", "henan", "123456"));
            add(new User("000-5678", "222", false, "xuexue", "henan", "123456"));
        }
    };

    private User currentUser = new User();

    public void setCurrentUser(User user){
        currentUser = user;
    }

    public User getCurrentUser(){
        return currentUser;
    }

    public String getWelcomeMessage(){

        return "*****Welcom to TWU Library!*****\n\n";
    }

    public ArrayList<Book> ListBooks(){
        ArrayList<Book> unCheckBookList = new ArrayList<Book>();
        for (Book allBook : allBooks) {
            if (!allBook.getStatus())
                unCheckBookList.add(allBook);
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
        for (Book allBook : allBooks) {
            if (allBook.getBookName().equals(name) && !allBook.getStatus()) {
                allBook.setStatus(true);
                allBook.setLibraryNumber(currentUser.getLibraryNumber());
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String name){
        for (Book allBook : allBooks) {
            if (allBook.getBookName().equals(name) && allBook.getStatus() && allBook.getLibraryNumber().equals(currentUser.getLibraryNumber())) {
                allBook.setStatus(false);
                return true;
            }
        }
        return false;
    }

    public boolean checkoutMovie(String name) {
        for (Movie allMovy : allMovies) {
            if (allMovy.getMovieName().equals(name))
                return true;
        }
        return false;
    }

    public boolean isLogIn(String userInput) {
        for (User allUser : allUsers) {
            if(userInput.indexOf(',') == -1)
                return false;
            String libraryNumber = userInput.split(",")[0].trim();
            String password = userInput.split(",")[1].trim();
            if(libraryNumber.equals("") && userInput.equals(""))
                return  false;
            if (libraryNumber.equals(allUser.getLibraryNumber()) && password.equals(allUser.getPassword())) {
                setCurrentUser(allUser);
                currentUser.setIsLogin(true);
                return true;
            }
        }
        return false;
    }

    public User getUserInformation() {
        if(currentUser.getIsLogin()){
            for (User allUser : allUsers) {
                if (currentUser.getLibraryNumber().equals(allUser.getLibraryNumber()))
                    return allUser;
            }
        }
        return null;
    }
}
