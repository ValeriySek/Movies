package com.hfad.mymovies.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.hfad.mymovies.data.MovieRepository;
import com.hfad.mymovies.data.models.MovieDiscover;

import java.util.List;
import java.util.Locale;

public class MainFragmentViewModel extends ViewModel {

    private MovieRepository mMovieRepository;
    private int page = 1;
    private String methodOfSort = "popularity.desc";
    private String language = Locale.getDefault().getLanguage();

    public MainFragmentViewModel(MovieRepository movieRepository) {
        mMovieRepository = movieRepository;
    }

    public LiveData<List<MovieDiscover>> getMovieList() {
        Log.i("ProblemVMget", "" + page);
        if(methodOfSort.equals("upcoming")){
            return mMovieRepository.getUpcomingMovies(page, language);
        }
        return mMovieRepository.getMovies(page, methodOfSort, language);
    }

    public void increasePage(){
        page++;
    }

    public void setFirstPage() {
        this.page = 1;
    }

    public void setMethodOfSort(String method){
        methodOfSort = method;
    }



}
