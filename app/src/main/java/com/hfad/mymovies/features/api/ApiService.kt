package com.hfad.mymovies.features.api

import com.hfad.mymovies.core.interactor.API_KEY
import com.hfad.mymovies.core.network.models.ExampleResponse
import com.hfad.mymovies.core.network.models.ReviewsResponse
import com.hfad.mymovies.core.network.models.MovieDetailedResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {


    @GET("movie/{movie_id}?$API_KEY")
    fun getExampleMovie(
            @Path("movie_id") movieId: Int,
            @Query("language") language: String?
    ): Observable<MovieDetailedResponse>

    @GET("movie/{movie_id}/credits?$API_KEY")
    fun getCast(
            @Path("movie_id") movieId: Int,
            @Query("language") language: String?
    ): Observable<ExampleResponse>

    @GET("search/movie?$API_KEY")
    fun getSearchMovies(
            @Query("language") language: String?,
            @Query("query") name: String?
    ): Observable<ExampleResponse>

    @GET("movie/{movie_id}/recommendations?$API_KEY&include_adult=false&include_video=false}")
    fun getRecommended(
            @Path("movie_id") movieId: Int,
            @Query("language") language: String?,
            @Query("page") page: Int
    ): Observable<ExampleResponse>

    @GET("movie/upcoming?$API_KEY")
    fun getUpcoming(
            @Query("language") language: String?,
            @Query("page") page: Int
    ): Observable<ExampleResponse>

    @GET("movie/{movie_id}/reviews?$API_KEY")
    fun getReviews(
            @Path("movie_id") movieId: Int,
            @Query("language") language: String?
    ): Observable<ReviewsResponse>
}