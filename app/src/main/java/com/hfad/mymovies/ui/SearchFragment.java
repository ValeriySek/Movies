package com.hfad.mymovies.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.hfad.mymovies.adapters.MovieAdapter;
import com.hfad.mymovies.data.models.MovieDiscover;
import com.hfad.mymovies.databinding.FragmentSearchBinding;
import com.hfad.mymovies.utils.InjectorUtils;
import com.hfad.mymovies.viewmodels.SearchFragmentViewModel;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class SearchFragment extends Fragment {

    private SearchFragmentViewModel mViewModel;
    private MovieAdapter mMovieAdapter;
    private FragmentSearchBinding mBinding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        FragmentSearchBinding binding = FragmentSearchBinding.inflate(inflater, container, false);
        mViewModel = new ViewModelProvider(this, InjectorUtils.provideHomeViewModelFactory()).get(SearchFragmentViewModel.class);

        mMovieAdapter = new MovieAdapter(this);

        binding.rvSearch.setAdapter(mMovieAdapter);

        setListeners();

        return binding.getRoot();
    }

    private void setListeners(){
        mBinding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String encoder = "";
                try {
                    encoder = URLEncoder.encode(query, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                loadData(encoder);
                Toast.makeText(getContext(), "" +query+ "\n" + encoder, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void loadData(String name){
        mViewModel.searchMovie(name).observe(getViewLifecycleOwner(), new Observer<List<MovieDiscover>>() {
            @Override
            public void onChanged(List<MovieDiscover> movieDiscovers) {
                Log.i("LoadSearch", "" + movieDiscovers);
                mMovieAdapter.setMovieList(movieDiscovers);
            }
        });
    }
}