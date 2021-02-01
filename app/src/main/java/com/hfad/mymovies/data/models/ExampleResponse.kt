package com.hfad.mymovies.data.models

import com.google.gson.annotations.SerializedName

data class ExampleResponse (
    @SerializedName("page")
    var page: Int = 0,
    @SerializedName("total_results")
    var totalResults: Int = 0,
    @SerializedName("total_pages")
    var totalPages: Int = 0,
    @SerializedName("results")
    var results: List<MovieDiscover>? = null,
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("cast")
    var cast: List<Actors>? = null,
    @SerializedName("crew")
    var crew: List<Crew>? = null,
    @SerializedName("genres")
    var genres: List<Genre>? = null
)