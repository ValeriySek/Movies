package com.hfad.mymovies.viewmodels.factories;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.hfad.mymovies.data.MovieRepository;
import com.hfad.mymovies.viewmodels.MainFragmentViewModel;

public class MainFragmentViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private MovieRepository mRepository;

    public MainFragmentViewModelFactory(MovieRepository repository) {
        mRepository = repository;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(MainFragmentViewModel.class)){
            return (T) new MainFragmentViewModel(mRepository);
        } else {
            throw new IllegalArgumentException("Wrong class");
        }
    }
}
