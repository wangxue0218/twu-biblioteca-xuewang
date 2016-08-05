package com.twu.biblioteca.Service;

import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.Movie;
import com.twu.biblioteca.Model.User;
import com.twu.biblioteca.Resource.DataResource;

import java.util.ArrayList;

public class LibraryService {

    private ArrayList<Book> allBooks = new DataResource().getAllBooks();

    private ArrayList<Movie> allMovies = new DataResource().getAllMovies();

    private ArrayList<User> allUsers = new DataResource().getAllUsers();

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
