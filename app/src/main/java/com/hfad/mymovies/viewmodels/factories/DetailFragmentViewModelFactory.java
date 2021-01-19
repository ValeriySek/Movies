package com.hfad.mymovies.viewmodels.factories;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

//import com.hfad.mymovies.data.FavouriteMovieRepository;
import com.hfad.mymovies.data.MovieRepository;
import com.hfad.mymovies.viewmodels.DetailFragmentViewModel;

//public class DetailFragmentViewModelFactory extends ViewModelProvider.NewInstanceFactory {
//
//    private MovieRepository mMovieRepository;
//    private FavouriteMovieRepository mFavouriteMovieRepository;
//    private int mMovieId;
//
//
//    public DetailFragmentViewModelFactory(MovieRepository movieRepository, FavouriteMovieRepository favouriteMovieRepository, int movieId) {
//        mMovieRepository = movieRepository;
//        mFavouriteMovieRepository = favouriteMovieRepository;
//        mMovieId = movieId;
//    }
//
//    @SuppressWarnings("unchecked")
//    @NonNull
//    @Override
//    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
//        if(modelClass.isAssignableFrom(DetailFragmentViewModel.class)){
//            return (T) new DetailFragmentViewModel(mMovieRepository, mFavouriteMovieRepository, mMovieId);
//        } else {
//            throw new IllegalArgumentException("Wrong class");
//        }
//
//    }
//}
