package com.hfad.mymovies.core.domain

import com.hfad.mymovies.core.utils.EMPTY_STRING

data class MovieDetailed(
        val isAdult: Boolean = false,
        val backdropPath: String = EMPTY_STRING,
//        val belongsToCollection: Any,
        val budget: Int = 0,
        val genres: List<Genre> = emptyList(),
        val homepage: String = EMPTY_STRING,
        val id: Int = 0,
        val imdbId: String = EMPTY_STRING,
        val originalLanguage: String = EMPTY_STRING,
        val originalTitle: String = EMPTY_STRING,
        val overview: String = EMPTY_STRING,
        val popularity: Double = 0.0,
        val posterPath: String = EMPTY_STRING,
//        val productionCompanies: List<ProductionCompany> = emptyList(),
//        val productionCountries: List<ProductionCountry> = emptyList(),
        val releaseDate: String = EMPTY_STRING,
        val revenue: Int = 0,
        val runtime: Int = 0,
//        val spokenLanguages: List<SpokenLanguages> = emptyList(),
        val status: String = EMPTY_STRING,
        val tagline: String = EMPTY_STRING,
        val title: String = EMPTY_STRING,
        val hasVideo: Boolean = false,
        val voteAverage: Double = 0.0,
        val voteCount: Int = 0
)
