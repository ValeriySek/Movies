package com.hfad.mymovies.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.hfad.mymovies.adapters.FavouriteMovieAdapter;
import com.hfad.mymovies.data.models.FavouriteMovie;
import com.hfad.mymovies.databinding.FragmentFavouriteBinding;
import com.hfad.mymovies.utils.InjectorUtils;
import com.hfad.mymovies.viewmodels.FavouriteFragmentViewModel;

import java.util.List;

public class FavouriteFragment extends Fragment {

    private FavouriteMovieAdapter mAdapter;
    private FragmentFavouriteBinding mBinding;
    private FavouriteFragmentViewModel mViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentFavouriteBinding.inflate(inflater, container, false);

        mViewModel = new ViewModelProvider(this,
                        InjectorUtils.provideFavouriteFragmentViewModelFactory(getContext()))
                .get(FavouriteFragmentViewModel.class);

        mAdapter = new FavouriteMovieAdapter();
        mBinding.rvFavouriteMovies.setAdapter(mAdapter);

        subscribeUi();

        return mBinding.getRoot();
    }

    private void subscribeUi(){
        mViewModel.getFavouriteMovies().observe(getViewLifecycleOwner(), new Observer<List<FavouriteMovie>>() {
            @Override
            public void onChanged(List<FavouriteMovie> favouriteMovies) {
                mAdapter.setMovieList(favouriteMovies);
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
