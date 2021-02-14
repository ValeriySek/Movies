package com.hfad.mymovies.core.network.models

import com.google.gson.annotations.SerializedName
import com.hfad.mymovies.core.domain.Review
import com.hfad.mymovies.core.network.Transformable
import com.hfad.mymovies.core.utils.EMPTY_STRING

class ReviewResponse(
        @SerializedName("author") val author: String?,
        @SerializedName("content") val content: String?
) : Transformable<Review> {

        override fun transform(): Review {
                return Review(
                        author ?: EMPTY_STRING,
                        content ?: EMPTY_STRING
                )
        }

}