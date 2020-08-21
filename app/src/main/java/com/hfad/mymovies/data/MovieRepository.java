package com.hfad.mymovies.data;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hfad.mymovies.api.ApiFactory;
import com.hfad.mymovies.api.ApiService;
import com.hfad.mymovies.data.models.Actors;
import com.hfad.mymovies.data.models.ExampleResponse;
import com.hfad.mymovies.data.models.ExampleReview;
import com.hfad.mymovies.data.models.Genre;
import com.hfad.mymovies.data.models.Movie;
import com.hfad.mymovies.data.models.MovieDiscover;
import com.hfad.mymovies.data.models.Review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MovieRepository {

    private static MovieRepository sMovieRepository;

    private ApiService apiService;
    private List<MovieDiscover> mMovieDiscovers;

    private MovieRepository() {
        ApiFactory apiFactory = ApiFactory.getInstance();
        apiService = apiFactory.getApiService();
        mMovieDiscovers = new ArrayList<>();
    }

    public static MovieRepository getInstance(){
        if(sMovieRepository == null){
            sMovieRepository = new MovieRepository();
        }
        return sMovieRepository;
    }

    public MutableLiveData<List<MovieDiscover>> getMovies(final int page, String sortBy, String language){
        final MutableLiveData<List<MovieDiscover>> listMovies = new MutableLiveData<>();

        apiService.getExample(language, page, sortBy, 100)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ExampleResponse>() {
                    @Override
                    public void accept(ExampleResponse exampleResponse) throws Exception {
                        if((mMovieDiscovers.size() + 20) / page == 20)
                        mMovieDiscovers.addAll(exampleResponse.getResults());

                        listMovies.setValue(mMovieDiscovers);
                        Log.i("ProblemMRsize", "" + mMovieDiscovers.size());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

        return listMovies;
    }


    public LiveData<Movie> getMovie(int movieId, String language){
        final MutableLiveData<Movie> fMovie = new MutableLiveData<>();

        apiService.getExampleMovie(movieId, language)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Movie>() {
                    @Override
                    public void accept(Movie movie) throws Exception {

                        fMovie.setValue(movie);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
        return fMovie;
    }

    public LiveData<List<Actors>> getActors(int movieId, String language){
        final MutableLiveData<List<Actors>> fActors = new MutableLiveData<>();

        apiService.getCast(movieId, language)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ExampleResponse>() {
                    @Override
                    public void accept(ExampleResponse exampleResponse) throws Exception {
                        fActors.setValue(exampleResponse.getCast());
                        Log.i("ProblemMRM", "" + exampleResponse.getCast().size());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
        return fActors;
    }

    public LiveData<List<MovieDiscover>> searchMovie(String name, String language){

        final MutableLiveData<List<MovieDiscover>> fMovie = new MutableLiveData<>();

        apiService.getSearchMovies(language, name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ExampleResponse>() {
                    @Override
                    public void accept(ExampleResponse exampleResponse) throws Exception {
                        fMovie.setValue(exampleResponse.getResults());
                        Log.i("LoadSearchM", "" + exampleResponse.getResults().size());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
        return fMovie;
    }
    public MutableLiveData<List<MovieDiscover>> getRecommended(final int page, int movieId, String language){
        final MutableLiveData<List<MovieDiscover>> listMovies = new MutableLiveData<>();

        apiService.getRecommended(movieId, language, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ExampleResponse>() {
                    @Override
                    public void accept(ExampleResponse exampleResponse) throws Exception {

                        listMovies.setValue(exampleResponse.getResults());
                        Log.i("ProblemMRsize", "" + mMovieDiscovers.size());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

        return listMovies;
    }

    public MutableLiveData<List<MovieDiscover>> getUpcomingMovies(final int page, String language){
        final MutableLiveData<List<MovieDiscover>> listMovies = new MutableLiveData<>();

        apiService.getUpcoming(language, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ExampleResponse>() {
                    @Override
                    public void accept(ExampleResponse exampleResponse) throws Exception {
                        if((mMovieDiscovers.size() + 20) / page == 20)
                            mMovieDiscovers.addAll(exampleResponse.getResults());

                        listMovies.setValue(mMovieDiscovers);
                        Log.i("ProblemMRsize", "" + mMovieDiscovers.size());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

        return listMovies;
    }

    public MutableLiveData<List<Review>> getReviews(int movieId, String language){
        final MutableLiveData<List<Review>> listReviews = new MutableLiveData<>();

        apiService.getReviews(movieId, language)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ExampleReview>() {
                    @Override
                    public void accept(ExampleReview exampleReview) throws Exception {

                        listReviews.setValue(exampleReview.getReviews());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

        return listReviews;
    }
}
