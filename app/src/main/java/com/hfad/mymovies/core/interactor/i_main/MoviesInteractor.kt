package com.hfad.mymovies.core.interactor.i_main

import com.hfad.mymovies.core.domain.Example
import com.hfad.mymovies.core.domain.Movies
import com.hfad.mymovies.core.utils.extentoins.transform
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

class MoviesInteractor @Inject constructor(
        private val repository: MoviesRepository
) {

    fun getMovies(page: Int, sortBy: String?, language: String?): Flowable<List<Movies>> {
        return repository.getMovies(page, language, sortBy)
                .map {
                    it.results.transform()
                }
    }
}