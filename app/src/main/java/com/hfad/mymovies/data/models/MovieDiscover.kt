package com.hfad.mymovies.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
open class MovieDiscover(
        @SerializedName("popularity")
        private var popularity: Double = 0.0,
        @SerializedName("vote_count")
        private var voteCount: Int = 0,
        @SerializedName("video")
        private var video: Boolean = false,
        @SerializedName("poster_path")
        private var posterPath: String? = null,
        @PrimaryKey
        @SerializedName("id")
        private var id: Int = 0,
        @SerializedName("adult")
        private var adult: Boolean = false,
        @SerializedName("backdrop_path")
        private var backdropPath: String? = null,
        @SerializedName("original_language")
        private var originalLanguage: String? = null,
        @SerializedName("original_title")
        private var originalTitle: String? = null,
        @SerializedName("genre_ids")
        private var genreIds: List<Int>? = null,
        @SerializedName("title")
        private var title: String? = null,
        @SerializedName("vote_average")
        private var voteAverage: Double = 0.0,
        @SerializedName("overview")
        private var overview: String? = null,
        @SerializedName("release_date")
        private var releaseDate: String? = null,
)