package com.hfad.mymovies.data.models

import com.google.gson.annotations.SerializedName

class Review(
        @SerializedName("author")
        private val author: String? = null,
        @SerializedName("content")
        private val content: String? = null
)