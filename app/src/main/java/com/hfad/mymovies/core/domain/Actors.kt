package com.hfad.mymovies.core.domain

import com.hfad.mymovies.core.utils.EMPTY_STRING


data class Actors(
        var castId: Int = 0,
        var character: String = EMPTY_STRING,
        var creditId: String = EMPTY_STRING,
        var gender: Int = 0,
        var id: Int = 0,
        var name: String = EMPTY_STRING,
        var order: Int = 0,
        val profilePath: String = EMPTY_STRING
)
