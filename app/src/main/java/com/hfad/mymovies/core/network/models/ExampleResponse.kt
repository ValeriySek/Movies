package com.hfad.mymovies.core.network.models

import com.google.gson.annotations.SerializedName
import com.hfad.mymovies.core.domain.Example
import com.hfad.mymovies.core.network.Transformable
import com.hfad.mymovies.core.utils.extentoins.transform

data class ExampleResponse(
        @SerializedName("page") val page: Int?,
        @SerializedName("total_results") val totalResults: Int?,
        @SerializedName("total_pages") val totalPages: Int?,
        @SerializedName("results") val results: List<MoviesResponse>?,
        @SerializedName("id") val id: Int?,
        @SerializedName("cast") val cast: List<ActorsResponse>?,
        @SerializedName("crew") val crew: List<CrewResponse>?,
        @SerializedName("genres") val genres: List<GenreResponse>?
) : Transformable<Example> {

    override fun transform(): Example {
        return Example(
                page ?: 0,
                totalResults ?: 0,
                totalPages ?: 0,
                results ?: emptyList(),
                id ?: 0,
                cast.transform(),
                crew.transform(),
                genres.transform()
        )
    }

}