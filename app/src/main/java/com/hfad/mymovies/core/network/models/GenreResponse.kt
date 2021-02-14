package com.hfad.mymovies.core.network.models

import com.google.gson.annotations.SerializedName
import com.hfad.mymovies.core.domain.Genre
import com.hfad.mymovies.core.network.Transformable
import com.hfad.mymovies.core.utils.EMPTY_STRING

data class GenreResponse(
        @SerializedName("id") val id: Int?,
        @SerializedName("name") val name: String?
) : Transformable<Genre> {

        override fun transform(): Genre {
                return Genre(
                        id ?: 0,
                        name ?: EMPTY_STRING
                )
        }

}