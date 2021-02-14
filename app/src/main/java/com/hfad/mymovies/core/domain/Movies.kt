package com.hfad.mymovies.core.domain

import com.hfad.mymovies.core.utils.EMPTY_STRING

data class Movies(
        val adult: Boolean = false,
        val backdropPath: String = EMPTY_STRING,
        val genreIds: List<Int> = emptyList(),
        val id: Int = 0,
        val originalLanguage: String = EMPTY_STRING,
        val originalTitle: String = EMPTY_STRING,
        val overview: String = EMPTY_STRING,
        val popularity: Double = 0.0,
        val posterPath: String = EMPTY_STRING,
        val releaseDate: String = EMPTY_STRING,
        val title: String = EMPTY_STRING,
        val video: Boolean = false,
        val voteAverage: Double = 0.0,
        val voteCount: Int = 0
)