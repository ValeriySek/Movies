package com.hfad.mymovies.di

import com.hfad.mymovies.api.ApiService
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
private const val BASE_URL = "https://api.themoviedb.org/3/"

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideService(): ApiService {

        val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build()

        return retrofit.create(ApiService::class.java)
    }
}