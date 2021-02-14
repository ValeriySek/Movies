package com.hfad.mymovies.core.domain

import com.google.gson.annotations.SerializedName
import com.hfad.mymovies.core.utils.EMPTY_STRING

data class Review(
        val author: String = EMPTY_STRING,
        val content: String = EMPTY_STRING
)
