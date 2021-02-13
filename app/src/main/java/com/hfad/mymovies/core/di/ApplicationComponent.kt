package com.hfad.mymovies.core.di

import com.hfad.mymovies.features.MainActivity
import com.hfad.mymovies.features.details.DetailFragment
import com.hfad.mymovies.features.favourites.FavouriteFragment
import com.hfad.mymovies.features.main.MainFragment
import com.hfad.mymovies.features.search.SearchFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    NetworkModule::class,
    ViewModelModule::class
])
interface ApplicationComponent {

    fun inject(activity: MainActivity)
    fun inject(mainFragment: MainFragment)
    fun inject(detailFragment: DetailFragment)
    fun inject(fragment: FavouriteFragment)
    fun inject(fragment: SearchFragment)
}