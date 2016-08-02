package com.twu.biblioteca.Model;

/**
 * Created by xuewang on 8/2/16.
 */
public class User {
    private String libraryNumber;
    private String password;
    private boolean isLogin = false;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public User() {

    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public boolean getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean status) {
        isLogin = status;
    }

    public void setLibraryNumber(String libraryNumber) {
        this.libraryNumber = libraryNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
