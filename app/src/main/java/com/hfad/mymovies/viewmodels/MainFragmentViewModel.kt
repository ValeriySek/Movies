package com.hfad.mymovies.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hfad.mymovies.data.MovieRepository
import com.hfad.mymovies.data.models.MovieDiscover
import java.util.*
import javax.inject.Inject

class MainFragmentViewModel @Inject constructor(
        private val movieRepository: MovieRepository
        ) : ViewModel() {

    private var page = 1
    private var methodOfSort = "popularity.desc"
    private val language = Locale.getDefault().language
    val movieList: LiveData<MutableList<MovieDiscover>>
        get() {
            Log.i("ProblemVMget", "" + page)
            return if (methodOfSort == "upcoming") {
                movieRepository.getUpcomingMovies(page, language)
            } else movieRepository.getMovies(page, methodOfSort, language)
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
}