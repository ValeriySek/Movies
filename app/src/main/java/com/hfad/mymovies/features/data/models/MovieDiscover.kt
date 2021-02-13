package com.hfad.mymovies.features.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
open class MovieDiscover(
        @SerializedName("popularity")
        var popularity: Double = 0.0,
        @SerializedName("vote_count")
        var voteCount: Int = 0,
        @SerializedName("video")
        var video: Boolean = false,
        @SerializedName("poster_path")
        var posterPath: String? = null,
        @PrimaryKey
        @SerializedName("id")
        var id: Int = 0,
        @SerializedName("adult")
        var adult: Boolean = false,
        @SerializedName("backdrop_path")
        var backdropPath: String? = null,
        @SerializedName("original_language")
        var originalLanguage: String? = null,
        @SerializedName("original_title")
        var originalTitle: String? = null,
        @SerializedName("genre_ids")
        var genreIds: List<Int>? = null,
        @SerializedName("title")
        var title: String? = null,
        @SerializedName("vote_average")
        var voteAverage: Double = 0.0,
        @SerializedName("overview")
        var overview: String? = null,
        @SerializedName("release_date")
        var releaseDate: String? = null,
)