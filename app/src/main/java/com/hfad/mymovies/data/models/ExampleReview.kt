package com.hfad.mymovies.data.models

import com.google.gson.annotations.SerializedName

data class ExampleReview(
        @SerializedName("results")
        var reviews: List<Review>? = null
)