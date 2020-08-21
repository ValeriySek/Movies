package com.hfad.mymovies.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.hfad.mymovies.data.models.MovieDiscover;
import com.hfad.mymovies.data.MovieRepository;

import java.util.List;
import java.util.Locale;

public class SearchFragmentViewModel extends ViewModel {

    private MovieRepository mMovieRepository;
    private String language = Locale.getDefault().getLanguage();

    public SearchFragmentViewModel(MovieRepository movieRepository) {
        mMovieRepository = movieRepository;
    }

    public LiveData<List<MovieDiscover>> searchMovie(String name){
        return mMovieRepository.searchMovie(name, language);
    }
}