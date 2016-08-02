package com.twu.biblioteca;

import com.twu.biblioteca.Service.LibraryService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class LibraryServiceTest_2 {
    @Test
    public void should_return_all_available_movies_with_name_year_director_rating_when_call_listMovies_method(){
        LibraryService libraryService = new LibraryService();
        assertEquals("Titanic", libraryService.listMovies().get(0).getMovieName());
        assertEquals("1997", libraryService.listMovies().get(0).getMovieYear());
        assertEquals("wangxue", libraryService.listMovies().get(0).getMovieDirector());
        assertEquals(9, libraryService.listMovies().get(0).getMovieRating());
        assertEquals("Movie2", libraryService.listMovies().get(1).getMovieName());
        assertEquals("1990", libraryService.listMovies().get(1).getMovieYear());
        assertEquals("xuewang", libraryService.listMovies().get(1).getMovieDirector());
        assertEquals(8, libraryService.listMovies().get(1).getMovieRating());
    }

    @Test
    public void should_return_true_when_user_input_valid_movie_name(){
        LibraryService libraryService = new LibraryService();
        boolean isAvailable = libraryService.checkoutMovie("Movie2");
        assertEquals(true, isAvailable);
    }

    @Test
    public void should_return_false_when_usar_input_Invalid_movie_name(){
        LibraryService libraryService = new LibraryService();
        boolean isAvailable = libraryService.checkoutMovie("hehe");
        assertEquals(false, isAvailable);
    }

    @Test
    public void should_return_true_when_user_input_valid_user_name_and_password(){
        LibraryService libraryService = new LibraryService();
        boolean isLogin = libraryService.isLogIn("123-4567,111");
        assertEquals(true, isLogin);
    }
}
