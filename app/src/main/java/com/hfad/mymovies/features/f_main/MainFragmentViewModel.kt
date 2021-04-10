package com.hfad.mymovies.features.f_main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hfad.mymovies.core.domain.Movies
import com.hfad.mymovies.core.interactor.i_main.MoviesInteractor
import com.hfad.mymovies.features.data.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

class MainFragmentViewModel @Inject constructor(
        private val movieRepository: MovieRepository,
        private val interactor: MoviesInteractor
) : ViewModel() {

    private var page = 1
    private var methodOfSort = "popularity.desc"
    private val language = Locale.getDefault().language

    private val compositeDisposable = CompositeDisposable()
    private val movieDiscovers: MutableList<Movies> = ArrayList()
    var movieList: MutableLiveData<List<Movies>> = MutableLiveData()

    fun getMovies() {
        if (methodOfSort == "upcoming") {
            movieList = movieRepository.getUpcomingMovies(page, language)
        } else compositeDisposable.add(interactor.getMovies(page, methodOfSort, language)
                .subscribe { movies ->
                    if ((movieDiscovers.size + 20) / page == 20) {
                        movieDiscovers.addAll(movies)
                        movieList.value = movieDiscovers
                    }
                })
    }

    fun increasePage() {
        page++
    }

    fun setFirstPage() {
        page = 1
    }

    fun setMethodOfSort(method: String?) {
        methodOfSort = method!!
    }

    override fun onCleared() {
        Log.i("TAGG", "onCleared")
        compositeDisposable.clear()
    }
}