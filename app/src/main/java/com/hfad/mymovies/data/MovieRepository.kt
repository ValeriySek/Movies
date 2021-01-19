package com.hfad.mymovies.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hfad.mymovies.api.ApiService
import com.hfad.mymovies.data.models.Actors
import com.hfad.mymovies.data.models.Movie
import com.hfad.mymovies.data.models.MovieDiscover
import com.hfad.mymovies.data.models.Review
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieRepository @Inject constructor(
        private val apiService: ApiService
) {

    private val mMovieDiscovers: MutableList<MovieDiscover> = ArrayList()

    fun getMovies(page: Int, sortBy: String?, language: String?): MutableLiveData<MutableList<MovieDiscover>> {
        val listMovies = MutableLiveData<MutableList<MovieDiscover>>()
        apiService.getExample(language, page, sortBy, 100)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ exampleResponse ->
                    if ((mMovieDiscovers.size + 20) / page == 20) mMovieDiscovers.addAll(exampleResponse.results)
                    listMovies.value = mMovieDiscovers
                    Log.i("ProblemMRsize", "" + mMovieDiscovers.size)
                }) { }
        return listMovies
    }

    fun getMovie(movieId: Int, language: String?): LiveData<Movie> {
        val fMovie = MutableLiveData<Movie>()
        apiService.getExampleMovie(movieId, language)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ movie -> fMovie.setValue(movie) }) { }
        return fMovie
    }

    fun getActors(movieId: Int, language: String?): LiveData<List<Actors>> {
        val fActors = MutableLiveData<List<Actors>>()
        apiService.getCast(movieId, language)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ exampleResponse ->
                    fActors.value = exampleResponse.cast
                    Log.i("ProblemMRM", "" + exampleResponse.cast.size)
                }) { }
        return fActors
    }

    fun searchMovie(name: String?, language: String?): LiveData<List<MovieDiscover>> {
        val fMovie = MutableLiveData<List<MovieDiscover>>()
        apiService.getSearchMovies(language, name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ exampleResponse ->
                    fMovie.value = exampleResponse.results
                    Log.i("LoadSearchM", "" + exampleResponse.results.size)
                }) { }
        return fMovie
    }

    fun getRecommended(page: Int, movieId: Int, language: String?): MutableLiveData<MutableList<MovieDiscover>> {
        val listMovies = MutableLiveData<MutableList<MovieDiscover>>()
        apiService.getRecommended(movieId, language, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ exampleResponse ->
                    listMovies.value = exampleResponse.results
                    Log.i("ProblemMRsize", "" + mMovieDiscovers.size)
                }) { }
        return listMovies
    }

    fun getUpcomingMovies(page: Int, language: String?): MutableLiveData<MutableList<MovieDiscover>> {
        val listMovies = MutableLiveData<MutableList<MovieDiscover>>()
        apiService.getUpcoming(language, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ exampleResponse ->
                    if ((mMovieDiscovers.size + 20) / page == 20) mMovieDiscovers.addAll(exampleResponse.results)
                    listMovies.value = mMovieDiscovers
                    Log.i("ProblemMRsize", "" + mMovieDiscovers.size)
                }) { }
        return listMovies
    }

    fun getReviews(movieId: Int, language: String?): MutableLiveData<List<Review>> {
        val listReviews = MutableLiveData<List<Review>>()
        apiService.getReviews(movieId, language)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ exampleReview -> listReviews.setValue(exampleReview.reviews) }) { }
        return listReviews
    }
}