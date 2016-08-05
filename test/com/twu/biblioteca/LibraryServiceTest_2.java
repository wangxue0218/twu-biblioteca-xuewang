package com.twu.biblioteca;

import com.twu.biblioteca.Model.User;
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

    @Test
    public void should_return_false_when_user_input_Invalid_user_name_and_password(){
        LibraryService libraryService = new LibraryService();
        boolean isLogin = libraryService.isLogIn("hsb-ncue,111");
        assertEquals(false, isLogin);
    }

    @Test
    public void should_return_fasle_when_user_input_valid_user_name_and_wrong_password(){
        LibraryService libraryService = new LibraryService();
        boolean isLogin = libraryService.isLogIn("123-4567,000");
        assertEquals(false, isLogin);
    }

    @Test
    public void should_return_true_when_user_input_valid_name_and_the_library_number_of_this_book_is_current_user_id(){
        LibraryService libraryService = new LibraryService();
        libraryService.setCurrentUser(new User("123-4567", "111"));
        libraryService.checkoutBook("Math");
        assertEquals(true, libraryService.returnBook("Math"));
    }

    @Test
    public void should_return_false_when_user_input_valid_name_and_the_library_number_of_this_book_is_not_current_user_id(){
        LibraryService libraryService = new LibraryService();
        libraryService.setCurrentUser(new User("123-4567", "111"));
        libraryService.checkoutBook("Math");
        libraryService.setCurrentUser(new User("000-5678", "222"));
        boolean result = libraryService.returnBook("Math");
        assertEquals(false, result);
    }

    @Test
    public void should_return_user_information_with_name_emailAdress_phoneNumber_when_call_getUserInformation_method_when_current_user_Login(){
        LibraryService libraryService = new LibraryService();
        libraryService.setCurrentUser(new User("000-5678", "222", true));
        User currUser = libraryService.getUserInformation();
        assertEquals("xuexue",currUser.getUserName());
        assertEquals("henan", currUser.getUserAdress());
        assertEquals("123456",currUser.getPhoneNumber());
    }
}
