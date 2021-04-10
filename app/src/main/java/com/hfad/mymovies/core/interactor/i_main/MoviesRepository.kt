package com.hfad.mymovies.core.interactor.i_main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.hfad.mymovies.core.domain.Example
import com.hfad.mymovies.core.domain.Movies
import com.hfad.mymovies.core.network.Transformable
import com.hfad.mymovies.core.network.models.ExampleResponse
import com.hfad.mymovies.core.utils.extentoins.transform
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MoviesRepository @Inject constructor(
        private val moviesApi: MoviesApi
) {


    private val movieDiscovers: MutableList<Movies> = ArrayList()

//    fun getMovies(page: Int, sortBy: String?, language: String?): MutableLiveData<List<Movies>> {
//        val listMovies = MutableLiveData<List<Movies>>()
//        moviesApi.getExample(language, page, sortBy, 100)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ exampleResponse ->
//                    if ((movieDiscovers.size + 20) / page == 20) {
//                        exampleResponse.results?.let { movieDiscovers.addAll(it.transform()) }
//                    }
//                    listMovies.value = movieDiscovers
//                    Log.i("ProblemMRsize", "" + movieDiscovers.size)
//                }) { }
//        return listMovies
//    }


    fun getMovies(page: Int, sortBy: String?, language: String?): Flowable<Example> {
        return getMoviesIfMay(page, language, sortBy)
                .map(Transformable<Example>::transform)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
//                .filter { (movieDiscovers.size + 20) / page == 20 }
//                .doOnNext {example ->
//                    example.results.let { movieDiscovers.addAll(it.transform()) }
//                }
    }

    private fun getMoviesIfMay(page: Int, sortBy: String?, language: String?) : Flowable<ExampleResponse> {
        return moviesApi.getExample(language, page, sortBy, 100)
    }
}