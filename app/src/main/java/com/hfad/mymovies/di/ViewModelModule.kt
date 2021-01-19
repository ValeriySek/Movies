package com.hfad.mymovies.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hfad.mymovies.data.MovieRepository
import com.hfad.mymovies.viewmodels.DetailFragmentViewModel
import com.hfad.mymovies.viewmodels.MainFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Provider

@Module
class ViewModelModule {

    @Provides
    fun bindViewModelFactory(providerMap: MutableMap<Class<out ViewModel>, Provider<ViewModel>>): ViewModelFactory{
        return ViewModelFactory(providerMap)
    }

    @Provides
    @IntoMap
    @ViewModelKey(MainFragmentViewModel::class)
    fun provideMoviesViewModel(moviesRepo: MovieRepository): ViewModel {
        return MainFragmentViewModel(moviesRepo)
    }

    @Provides
    @IntoMap
    @ViewModelKey(DetailFragmentViewModel::class)
    fun provideDetailFragmentViewModel(moviesRepo: MovieRepository): ViewModel {
        return DetailFragmentViewModel(moviesRepo)
    }
}