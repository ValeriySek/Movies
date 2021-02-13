package com.hfad.mymovies.features.api

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.themoviedb.org/3/"
class ApiFactory private constructor() {
    val apiService: ApiService
        get() = retrofit.create(ApiService::class.java)

    private lateinit var apiFactory: ApiFactory
    private var retrofit: Retrofit

    companion object {
        val apiFactory = ApiFactory
    }

    init {
        retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build()
    }
}