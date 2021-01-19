package com.hfad.mymovies.api

import com.hfad.mymovies.data.models.ExampleResponse
import com.hfad.mymovies.data.models.ExampleReview
import com.hfad.mymovies.data.models.Movie
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val API_KEY = "api_key=756d1951529fd2f2bc0df1846271d514"
interface ApiService {
    @GET("discover/movie?$API_KEY&include_adult=false&include_video=false}")
    fun getExample(
            @Query("language") language: String?,
            @Query("page") page: Int,
            @Query("sort_by") sort: String?,
            @Query("vote_count.gte") count: Int
    ): Observable<ExampleResponse>

    @GET("movie/{movie_id}?$API_KEY")
    fun getExampleMovie(
            @Path("movie_id") movieId: Int,
            @Query("language") language: String?
    ): Observable<Movie>

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
    ): Observable<ExampleReview>
}