package com.hfad.mymovies.utils;

import android.content.Context;

import com.hfad.mymovies.data.FavouriteMovieRepository;
import com.hfad.mymovies.data.MovieDatabase;
import com.hfad.mymovies.data.MovieRepository;
import com.hfad.mymovies.viewmodels.factories.SearchFragmentViewModelFactory;
import com.hfad.mymovies.viewmodels.factories.DetailFragmentViewModelFactory;
import com.hfad.mymovies.viewmodels.factories.FavouriteFragmentViewModelFactory;
import com.hfad.mymovies.viewmodels.factories.MainFragmentViewModelFactory;

public class InjectorUtils {

    private static MovieRepository getMovieRepository(){
        return MovieRepository.getInstance();
    }

    private static FavouriteMovieRepository getFavouriteMovieRepository(Context context){
        return FavouriteMovieRepository.getInstance(MovieDatabase.getInstance(context.getApplicationContext()).movieDao());
    }

    public static FavouriteFragmentViewModelFactory provideFavouriteFragmentViewModelFactory(Context context){
        return new FavouriteFragmentViewModelFactory(getFavouriteMovieRepository(context));
    }

    public static MainFragmentViewModelFactory provideMainFragmentViewModelFactory(){
        MovieRepository repository = getMovieRepository();
        return new MainFragmentViewModelFactory(repository);
    }

    public static SearchFragmentViewModelFactory provideHomeViewModelFactory(){
        MovieRepository repository = getMovieRepository();
        return new SearchFragmentViewModelFactory(repository);
    }

    public static DetailFragmentViewModelFactory provideDetailFragmentViewModelFactory(Context context, int movieId){
        return new DetailFragmentViewModelFactory(getMovieRepository(), getFavouriteMovieRepository(context), movieId);
    }
}
