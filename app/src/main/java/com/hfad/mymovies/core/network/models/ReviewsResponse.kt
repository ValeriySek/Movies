package com.hfad.mymovies.core.network.models

import com.google.gson.annotations.SerializedName
import com.hfad.mymovies.core.domain.Reviews
import com.hfad.mymovies.core.network.Transformable
import com.hfad.mymovies.core.utils.extentoins.transform

data class ReviewsResponse(
        @SerializedName("results") val reviews: List<ReviewResponse>?
) : Transformable<Reviews> {
    override fun transform(): Reviews {

        return Reviews(
                reviews.transform()
        )
    }

}