package com.hfad.mymovies.core.di

import androidx.lifecycle.ViewModel
import com.hfad.mymovies.features.data.MovieRepository
import com.hfad.mymovies.features.details.DetailFragmentViewModel
import com.hfad.mymovies.features.main.MainFragmentViewModel
import com.hfad.mymovies.features.search.SearchFragmentViewModel
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

    @Provides
    @IntoMap
    @ViewModelKey(SearchFragmentViewModel::class)
    fun provideSearchFragmentViewModel(moviesRepo: MovieRepository): ViewModel {
        return SearchFragmentViewModel(moviesRepo)
    }
}