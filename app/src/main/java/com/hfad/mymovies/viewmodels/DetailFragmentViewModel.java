package com.hfad.mymovies.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.hfad.mymovies.data.models.Actors;
import com.hfad.mymovies.data.FavouriteMovieRepository;
import com.hfad.mymovies.data.models.FavouriteMovie;
import com.hfad.mymovies.data.models.Movie;
import com.hfad.mymovies.data.models.MovieDiscover;
import com.hfad.mymovies.data.MovieRepository;
import com.hfad.mymovies.data.models.Review;

import java.util.List;
import java.util.Locale;

public class DetailFragmentViewModel extends ViewModel {

    private MovieRepository mMovieRepository;
    private FavouriteMovieRepository mFavouriteMovieRepository;
    private int mMovieId;
    private String language = Locale.getDefault().getLanguage();

    public DetailFragmentViewModel(MovieRepository movieRepository, FavouriteMovieRepository favouriteMovieRepository, int movieId) {
        mMovieRepository = movieRepository;
        mFavouriteMovieRepository = favouriteMovieRepository;
        mMovieId = movieId;
    }

    public LiveData<Movie> getMovie(){
        return mMovieRepository.getMovie(mMovieId, language);
    }

    public void addMovieToFavourite(Movie movie){
        Log.i("ProblemVMadd", "" + movie.getTitle());
        mFavouriteMovieRepository.addMovieToFavourite(movie);
    }

    public void deleteFromFavourite(){
        mFavouriteMovieRepository.deleteFavouriteMovie(
                mFavouriteMovieRepository.getFavouriteMovieById(mMovieId));
    }

    public LiveData<Boolean> isFavourite(){
        return mFavouriteMovieRepository.isFavourite(mMovieId);
    }

    public LiveData<List<Actors>> getActors(){
        return mMovieRepository.getActors(mMovieId, language);
    }

    public LiveData<List<MovieDiscover>> getMovies(){
        return mMovieRepository.getRecommended(1, mMovieId, language);
    }

    public FavouriteMovie getFavouriteMovie(){
        return mFavouriteMovieRepository.getFavouriteMovieById(mMovieId);
    }

    public LiveData<List<Review>> getReviews(){
        return mMovieRepository.getReviews(mMovieId, language);
    }
}
