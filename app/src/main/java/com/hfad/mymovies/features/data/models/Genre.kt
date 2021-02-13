package com.hfad.mymovies.features.data.models

import com.google.gson.annotations.SerializedName

data class Genre(
        @SerializedName("id")
        var id: Int = 0,
        @SerializedName("name")
        var name: String? = null
)