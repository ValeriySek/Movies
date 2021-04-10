package com.hfad.mymovies.core.interactor.i_main

import com.hfad.mymovies.core.interactor.API_KEY
import com.hfad.mymovies.core.network.models.ExampleResponse
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {


    @GET("discover/movie?$API_KEY&include_adult=false&include_video=false")
    fun getExample(
            @Query("language") language: String?,
            @Query("page") page: Int,
            @Query("sort_by") sort: String?,
            @Query("vote_count.gte") count: Int
    ): Flowable<ExampleResponse>
}