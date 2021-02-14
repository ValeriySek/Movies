package com.hfad.mymovies.features.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hfad.mymovies.core.domain.Actors
import com.hfad.mymovies.core.domain.MovieDetailed
import com.hfad.mymovies.core.domain.Movies
import com.hfad.mymovies.core.domain.Review
import com.hfad.mymovies.core.utils.extentoins.transform
import com.hfad.mymovies.features.api.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieRepository @Inject constructor(
        private val apiService: ApiService
) {

    private val mMovieDiscovers: MutableList<Movies> = ArrayList()

    fun getMovies(page: Int, sortBy: String?, language: String?): MutableLiveData<MutableList<Movies>> {
        val listMovies = MutableLiveData<MutableList<Movies>>()
        apiService.getExample(language, page, sortBy, 100)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ exampleResponse ->
                    if ((mMovieDiscovers.size + 20) / page == 20) {
                        exampleResponse.results?.let { mMovieDiscovers.addAll(it.transform()) }
                    }
                    listMovies.value = mMovieDiscovers
                    Log.i("ProblemMRsize", "" + mMovieDiscovers.size)
                }) { }
        return listMovies
    }

    fun getMovie(movieId: Int, language: String?): LiveData<MovieDetailed> {
        val fMovie = MutableLiveData<MovieDetailed>()
        apiService.getExampleMovie(movieId, language)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ movie -> fMovie.setValue(movie.transform()) }) { }
        return fMovie
    }

    fun getActors(movieId: Int, language: String?): LiveData<List<Actors>> {
        val fActors = MutableLiveData<List<Actors>>()
        apiService.getCast(movieId, language)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ exampleResponse ->
                    fActors.value = exampleResponse.cast.transform()
                    Log.i("ProblemMRM", "" + exampleResponse.cast?.size)
                }) { }
        return fActors
    }

    fun searchMovie(name: String?, language: String?): LiveData<List<Movies>> {
        val fMovie = MutableLiveData<List<Movies>>()
        apiService.getSearchMovies(language, name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ exampleResponse ->
                    fMovie.value = exampleResponse.results.transform()
                    Log.i("LoadSearchM", "" + exampleResponse.results?.size)
                }) { }
        return fMovie
    }

    fun getRecommended(page: Int, movieId: Int, language: String?): MutableLiveData<List<Movies>> {
        val listMovies = MutableLiveData<List<Movies>>()
        apiService.getRecommended(movieId, language, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ exampleResponse ->
                    listMovies.value = exampleResponse.results.transform()
                    Log.i("ProblemMRsize", "" + mMovieDiscovers.size)
                }) { }
        return listMovies
    }

    fun getUpcomingMovies(page: Int, language: String?): MutableLiveData<MutableList<Movies>> {
        val listMovies = MutableLiveData<MutableList<Movies>>()
        apiService.getUpcoming(language, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ exampleResponse ->
                    if ((mMovieDiscovers.size + 20) / page == 20) exampleResponse.results?.let { mMovieDiscovers.addAll(it.transform()) }
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
                .subscribe({ exampleReview -> listReviews.setValue(exampleReview.reviews.transform()) }) { }
        return listReviews
    }
}