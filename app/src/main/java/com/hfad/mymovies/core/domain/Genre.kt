package com.hfad.mymovies.core.domain

import com.google.gson.annotations.SerializedName
import com.hfad.mymovies.core.utils.EMPTY_STRING

data class Genre(
        val id: Int = 0,
        val name: String = EMPTY_STRING
)
