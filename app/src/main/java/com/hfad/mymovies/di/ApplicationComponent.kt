package com.hfad.mymovies.di

import com.hfad.mymovies.MainActivity
import com.hfad.mymovies.ui.DetailFragment
import com.hfad.mymovies.ui.MainFragment
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
}