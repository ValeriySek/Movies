package com.hfad.mymovies.features.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hfad.mymovies.core.domain.Movies
import com.hfad.mymovies.features.data.MovieRepository
import java.util.*
import javax.inject.Inject

class SearchFragmentViewModel @Inject constructor(
        private val movieRepository: MovieRepository
) : ViewModel() {
    private val language = Locale.getDefault().language
    fun searchMovie(name: String?): LiveData<List<Movies>> {
        return movieRepository.searchMovie(name, language)
    }
}