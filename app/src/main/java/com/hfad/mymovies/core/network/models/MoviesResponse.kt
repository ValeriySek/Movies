package com.hfad.mymovies.core.network.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.hfad.mymovies.core.domain.Movies
import com.hfad.mymovies.core.network.Transformable
import com.hfad.mymovies.core.utils.EMPTY_STRING

@Entity
open class MoviesResponse(
        @SerializedName("adult") val adult: Boolean = false,
        @SerializedName("backdrop_path") val backdropPath: String?,
        @SerializedName("genre_ids") val genreIds: List<Int>?,
        @PrimaryKey
        @SerializedName("id") val id: Int?,
        @SerializedName("original_language") val originalLanguage: String?,
        @SerializedName("original_title") val originalTitle: String?,
        @SerializedName("overview") val overview: String?,
        @SerializedName("popularity") val popularity: Double?,
        @SerializedName("poster_path") val posterPath: String?,
        @SerializedName("release_date") val releaseDate: String?,
        @SerializedName("title") val title: String?,
        @SerializedName("video") val video: Boolean = false,
        @SerializedName("vote_average") val voteAverage: Double?,
        @SerializedName("vote_count") val voteCount: Int?
) : Transformable<Movies> {

        override fun transform(): Movies {
                return Movies(
                        adult,
                        backdropPath ?: EMPTY_STRING,
                        genreIds ?: emptyList(),
                        id ?: 0,
                        originalLanguage ?: EMPTY_STRING,
                        originalTitle ?: EMPTY_STRING,
                        overview ?: EMPTY_STRING,
                        popularity ?: 0.0,
                        posterPath ?: EMPTY_STRING,
                        releaseDate ?: EMPTY_STRING,
                        title ?: EMPTY_STRING,
                        video,
                        voteAverage ?: 0.0,
                        voteCount ?: 0
                )
        }

}