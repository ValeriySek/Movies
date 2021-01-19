package com.hfad.mymovies.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hfad.mymovies.data.MovieRepository
import com.hfad.mymovies.data.models.MovieDiscover
import java.util.*

class SearchFragmentViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    private val language = Locale.getDefault().language
    fun searchMovie(name: String?): LiveData<List<MovieDiscover>> {
        return movieRepository.searchMovie(name, language)
    }
}