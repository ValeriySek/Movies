package com.hfad.mymovies.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.hfad.mymovies.ui.MainFragmentDirections;
import com.hfad.mymovies.R;
import com.hfad.mymovies.adapters.MovieAdapter;
import com.hfad.mymovies.data.models.MovieDiscover;
import com.hfad.mymovies.databinding.FragmentMainBinding;
import com.hfad.mymovies.utils.InjectorUtils;
import com.hfad.mymovies.viewmodels.MainFragmentViewModel;

import java.util.List;

public class MainFragment extends Fragment {

    private FragmentMainBinding binding;
    private MainFragmentViewModel mViewModel;
    private MovieAdapter movieAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentMainBinding.inflate(inflater, container, false);

        mViewModel = new ViewModelProvider(this,
                        InjectorUtils.provideMainFragmentViewModelFactory())
                .get(MainFragmentViewModel.class);

        movieAdapter = new MovieAdapter(this);
        binding.recyclerViewPosters.setAdapter(movieAdapter);

        loadData();
        setCallback();
        setListeners();
        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    private void setCallback(){
        Callback callback = new Callback() {
            @Override
            public void checkedChip(String sort) {
                movieAdapter.clear();
                mViewModel.setFirstPage();
                mViewModel.setMethodOfSort(sort);
                loadData();
            }
        };

        binding.setCallback(callback);
    }

    private void setListeners(){
        movieAdapter.setOnReachEndListener(new MovieAdapter.OnReachEndListener() {
            @Override
            public void onReachEnd() {
                mViewModel.increasePage();
                loadData();
            }
        });
    }

    private void loadData(){
        mViewModel.getMovieList().observe(getViewLifecycleOwner(), new Observer<List<MovieDiscover>>() {
            @Override
            public void onChanged(List<MovieDiscover> movieDiscovers) {
                movieAdapter.setMovieList(movieDiscovers);
            }
        });
    }

    public interface Callback{
        void checkedChip(String sort);
    }
}
