package com.hfad.mymovies.core.network.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "favourite_movies")
class FavouriteMovie(
        @PrimaryKey
        @SerializedName("id") val id: Int,
        @SerializedName("budget") val budget: Int,
        @SerializedName("genres") val genres: List<GenreResponse>? = null,
        @SerializedName("revenue") val revenue: Int,
        @SerializedName("runtime") val runtime: Int,
        @SerializedName("status") val status: String,
        @SerializedName("tagline") val tagline: String,
        @SerializedName("popularity") val popularity: Double,
        @SerializedName("vote_count") val voteCount: Int,
        @SerializedName("video") val isVideo: Boolean,
        @SerializedName("poster_path") val posterPath: String,
        @SerializedName("adult") val isAdult: Boolean,
        @SerializedName("backdrop_path") val backdropPath: String,
        @SerializedName("original_language") val originalLanguage: String,
        @SerializedName("original_title") val originalTitle: String,
        @SerializedName("title") val title: String,
        @SerializedName("vote_average") val voteAverage: Double,
        @SerializedName("overview") val overview: String,
        @SerializedName("release_date") val releaseDate: String
) {

//    @Ignore
//    constructor(movie: MovieDetailsResponse) : this(
//            id = movie.id,
//            budget = movie.budget,
//            genres = movie.genres,
//            revenue = movie.revenue,
//            runtime = movie.runtime,
//            status = movie.status,
//            tagline = movie.tagline,
//            popularity = movie.popularity,
//            voteCount = movie.voteCount,
//            isVideo = movie.video,
//            posterPath = movie.posterPath ?: "",
//            isAdult = movie.adult,
//            backdropPath = movie.backdropPath ?: "",
//            originalLanguage = movie.originalLanguage ?: "",
//            originalTitle = movie.originalTitle ?: "",
//            title = movie.title ?: "",
//            voteAverage = movie.voteAverage,
//            overview = movie.overview ?: "",
//            releaseDate = movie.releaseDate ?: "",
//    )
}