package com.hfad.mymovies.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.hfad.mymovies.data.models.FavouriteMovie;
import com.hfad.mymovies.data.FavouriteMovieRepository;

import java.util.List;

public class FavouriteFragmentViewModel extends ViewModel {

    private FavouriteMovieRepository mFavouriteMovieRepository;

    public FavouriteFragmentViewModel(FavouriteMovieRepository favouriteMovieRepository) {
        mFavouriteMovieRepository = favouriteMovieRepository;
    }

    public LiveData<List<FavouriteMovie>> getFavouriteMovies(){
        return mFavouriteMovieRepository.getFavouriteMovies();
    }
}
