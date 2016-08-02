package com.twu.biblioteca.Model;


public class Book {

    private String bookName;
    private String author;
    private String year;
    private boolean isChecked = false;

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

}