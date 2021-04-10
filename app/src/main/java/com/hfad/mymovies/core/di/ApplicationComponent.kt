package com.hfad.mymovies.core.di

import com.hfad.mymovies.core.di.api.ApiModule
import com.hfad.mymovies.features.MainActivity
import com.hfad.mymovies.features.f_details.DetailFragment
import com.hfad.mymovies.features.f_favourites.FavouriteFragment
import com.hfad.mymovies.features.f_main.MainFragment
import com.hfad.mymovies.features.f_search.SearchFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    NetworkModule::class,
    ViewModelModule::class,
    ApiModule::class
])
interface ApplicationComponent {

    fun inject(activity: MainActivity)
    fun inject(mainFragment: MainFragment)
    fun inject(detailFragment: DetailFragment)
    fun inject(fragment: FavouriteFragment)
    fun inject(fragment: SearchFragment)
}