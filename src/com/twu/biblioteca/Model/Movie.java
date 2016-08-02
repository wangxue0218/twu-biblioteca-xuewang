package com.twu.biblioteca.Model;

/**
 * Created by xuewang on 8/2/16.
 */
public class Movie {
    private String movieName;
    private String movieYear;
    private String movieDirector;
    private Integer movieRating;

    public Movie(String movieName, String movieYear, String movieDirector, Integer movieRating) {
        this.movieName = movieName;
        this.movieYear = movieYear;
        this.movieDirector = movieDirector;
        this.movieRating = movieRating;

    }

    public String getMovieName() {
        return movieName;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public String getMovieDirector() {
        return movieDirector;
    }
}
