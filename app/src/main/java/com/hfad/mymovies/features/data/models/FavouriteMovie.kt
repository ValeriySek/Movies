package com.hfad.mymovies.features.data.models

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "favourite_movies")
class FavouriteMovie(
        @PrimaryKey
        @SerializedName("id")
        var id: Int,
        @SerializedName("budget")
        var budget: Int,
        @SerializedName("genres")
        var genres: List<Genre>? = null,
        @SerializedName("revenue")
        var revenue: Int,
        @SerializedName("runtime")
        var runtime: Int,
        @SerializedName("status")
        var status: String,
        @SerializedName("tagline")
        var tagline: String,
        @SerializedName("popularity")
        var popularity: Double,
        @SerializedName("vote_count")
        var voteCount: Int,
        @SerializedName("video")
        var isVideo: Boolean,
        @SerializedName("poster_path")
        var posterPath: String,
        @SerializedName("adult")
        var isAdult: Boolean,
        @SerializedName("backdrop_path")
        var backdropPath: String,
        @SerializedName("original_language")
        var originalLanguage: String,
        @SerializedName("original_title")
        var originalTitle: String,
        @SerializedName("title")
        var title: String,
        @SerializedName("vote_average")
        var voteAverage: Double,
        @SerializedName("overview")
        var overview: String,
        @SerializedName("release_date")
        var releaseDate: String
) {

    @Ignore
    constructor(movie: Movie) : this(
            id = movie.id,
            budget = movie.budget,
            genres = movie.genres,
            revenue = movie.revenue,
            runtime = movie.runtime,
            status = movie.status,
            tagline = movie.tagline,
            popularity = movie.popularity,
            voteCount = movie.voteCount,
            isVideo = movie.video,
            posterPath = movie.posterPath ?: "",
            isAdult = movie.adult,
            backdropPath = movie.backdropPath ?: "",
            originalLanguage = movie.originalLanguage ?: "",
            originalTitle = movie.originalTitle ?: "",
            title = movie.title ?: "",
            voteAverage = movie.voteAverage,
            overview = movie.overview ?: "",
            releaseDate = movie.releaseDate ?: "",
    )
}