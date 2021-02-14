package com.hfad.mymovies.core.network.models

import com.google.gson.annotations.SerializedName
import com.hfad.mymovies.core.domain.MovieDetailed
import com.hfad.mymovies.core.network.Transformable
import com.hfad.mymovies.core.utils.EMPTY_STRING
import com.hfad.mymovies.core.utils.extentoins.transform

data class MovieDetailedResponse(
        @SerializedName("adult") val isAdult: Boolean = false,
        @SerializedName("backdrop_path") val backdropPath: String?,
//        @SerializedName("belongs_to_collection") val belongsToCollection: Any?,
        @SerializedName("budget") val budget: Int?,
        @SerializedName("genres") var genres: List<GenreResponse>?,
        @SerializedName("homepage") var homepage: String?,
        @SerializedName("id") val id: Int?,
        @SerializedName("imdb_id") var imdbId: String?,
        @SerializedName("original_language") val originalLanguage: String?,
        @SerializedName("original_title") val originalTitle: String?,
        @SerializedName("overview") val overview: String?,
        @SerializedName("popularity") val popularity: Double?,
        @SerializedName("poster_path") val posterPath: String?,
//        @SerializedName("production_companies") val productionCompanies: List<ProductionCompany>?,
//        @SerializedName("production_countries") val productionCountries: List<ProductionCountry>?,
        @SerializedName("release_date") val releaseDate: String?,
        @SerializedName("revenue") var revenue: Int?,
        @SerializedName("runtime") var runtime: Int?,
        //        @SerializedName("spoken_languages") val spokenLanguages: List<SpokenLanguages>?,
        @SerializedName("status") var status: String?,
        @SerializedName("tagline") var tagline: String?,
        @SerializedName("title") val title: String?,
        @SerializedName("video") val hasVideo: Boolean = false,
        @SerializedName("vote_average") val voteAverage: Double?,
        @SerializedName("vote_count") val voteCount: Int?
) : Transformable<MovieDetailed> {

    override fun transform(): MovieDetailed {
        return MovieDetailed(
                isAdult,
                backdropPath ?: EMPTY_STRING,
                budget ?: 0,
                genres.transform(),
                homepage ?: EMPTY_STRING,
                id ?: 0,
                imdbId ?: EMPTY_STRING,
                originalLanguage ?: EMPTY_STRING,
                originalTitle ?: EMPTY_STRING,
                overview ?: EMPTY_STRING,
                popularity ?: 0.0,
                posterPath ?: EMPTY_STRING,
                releaseDate ?: EMPTY_STRING,
                revenue ?: 0,
                runtime ?: 0,
                status ?: EMPTY_STRING,
                tagline ?: EMPTY_STRING,
                title ?: EMPTY_STRING,
                hasVideo,
                voteAverage ?: 0.0,
                voteCount ?: 0
        )
    }

}