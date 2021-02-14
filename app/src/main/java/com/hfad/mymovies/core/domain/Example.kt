package com.hfad.mymovies.core.domain

import com.hfad.mymovies.core.network.models.MoviesResponse

data class Example(
        val page: Int = 0,
        val totalResults: Int = 0,
        val totalPages: Int = 0,
        val results: List<MoviesResponse> = emptyList(),
        val id: Int = 0,
        val cast: List<Actors> = emptyList(),
        val crew: List<Crew> = emptyList(),
        val genres: List<Genre> = emptyList()
)