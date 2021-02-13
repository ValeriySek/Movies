package com.hfad.mymovies.features.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hfad.mymovies.features.data.MovieRepository
import com.hfad.mymovies.features.data.models.MovieDiscover
import java.util.*
import javax.inject.Inject

class SearchFragmentViewModel @Inject constructor(
        private val movieRepository: MovieRepository
) : ViewModel() {
    private val language = Locale.getDefault().language
    fun searchMovie(name: String?): LiveData<List<MovieDiscover>> {
        return movieRepository.searchMovie(name, language)
    }
}