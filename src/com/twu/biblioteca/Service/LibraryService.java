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

    protected ArrayList<Movie> allMovies = new ArrayList<Movie>(){
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
        for(int i=0; i<allBooks.size(); i++){
            if(allBooks.get(i).getBookName().equals(name)&& !allBooks.get(i).getStatus()){
                allBooks.get(i).setStatus(true);
                allBooks.get(i).setLibraryNumber(currentUser.getLibraryNumber());
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String name){
        for(int i=0; i<allBooks.size(); i++){
            if(allBooks.get(i).getBookName().equals(name)&& allBooks.get(i).getStatus() && allBooks.get(i).getLibraryNumber().equals(currentUser.getLibraryNumber())){
                allBooks.get(i).setStatus(false);
                return true;
            }
        }
        return false;
    }

    public boolean checkoutMovie(String name) {
        for(int i=0; i<allMovies.size(); i++){
            if(allMovies.get(i).getMovieName().equals(name))
                return true;
        }
        return false;
    }

    public boolean isLogIn(String userInput) {
        for(int i=0; i<allUsers.size(); i++){
            String libraryNumber = userInput.split(",")[0];
            String password = userInput.split(",")[1];
            if(libraryNumber.equals(allUsers.get(i).getLibraryNumber()) && password.equals(allUsers.get(i).getPassword())){
//                currentUser = allUsers.get(i);
                setCurrentUser(allUsers.get(i));
                currentUser.setIsLogin(true);
                return true;
            }
        }
        return false;
    }

    public User getUserInformation() {
        if(currentUser.getIsLogin()){
            for(int i=0; i< allUsers.size(); i++){
                if(currentUser.getLibraryNumber().equals(allUsers.get(i).getLibraryNumber()))
                    return allUsers.get(i);
            }
        }
        return null;
    }
}
