package com.hfad.mymovies.viewmodels.factories;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.hfad.mymovies.data.MovieRepository;
import com.hfad.mymovies.viewmodels.SearchFragmentViewModel;

public class SearchFragmentViewModelFactory extends ViewModelProvider.NewInstanceFactory {


    private MovieRepository mRepository;

    public SearchFragmentViewModelFactory(MovieRepository repository) {
        mRepository = repository;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(SearchFragmentViewModel.class)){
            return (T) new SearchFragmentViewModel(mRepository);
        }else {
            throw new IllegalArgumentException("Wrong class");
        }
    }
}
