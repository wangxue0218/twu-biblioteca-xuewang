package com.twu.biblioteca.Model;

/**
 * Created by xuewang on 8/2/16.
 */
public class User {
    private String libraryNumber;
    private String password;
    private boolean isLogin;
    private String userName;
    private String userAdress;
    private String phoneNumber;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public User() {

    }

    public User(String libraryNumber, String password, boolean isLogin, String userName, String userAdress, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.isLogin = isLogin;
        this.userName = userName;
        this.userAdress = userAdress;
        this.phoneNumber = phoneNumber;
    }

    public User(String libraryNumber, String password, boolean isLogin) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.isLogin = isLogin;
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

    public String getUserName() {
        return userName;
    }

    public String getUserAdress() {
        return userAdress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
