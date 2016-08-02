package com.twu.biblioteca.Model;


public class Book {

    private String bookName;
    private String author;
    private String year;
    private boolean isChecked = false;
    private String libraryNumber;

    public Book(String _bookName, String _author, String _year){
        this.bookName = _bookName;
        this.author = _author;
        this.year = _year;
    }

    public String getBookName(){
        return bookName;
    }

    public String getBookAuthor(){
        return author;
    }

    public String getBookYear(){
        return year;
    }

    public void setStatus(boolean status){
        this.isChecked = status;
    }

    public boolean getStatus(){
        return isChecked;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public void setLibraryNumber(String libraryNumber) {
        this.libraryNumber = libraryNumber;
    }
}