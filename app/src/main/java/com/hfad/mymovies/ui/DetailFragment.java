package com.hfad.mymovies.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.hfad.mymovies.adapters.CastAdapter;
import com.hfad.mymovies.adapters.MovieAdapter;
import com.hfad.mymovies.adapters.ReviewAdapter;
import com.hfad.mymovies.data.models.Actors;
import com.hfad.mymovies.data.models.Movie;
import com.hfad.mymovies.data.models.MovieDiscover;
import com.hfad.mymovies.data.models.Review;
import com.hfad.mymovies.databinding.FragmentDetailBinding;
import com.hfad.mymovies.utils.InjectorUtils;
import com.hfad.mymovies.viewmodels.DetailFragmentViewModel;

import java.util.List;

public class DetailFragment extends Fragment {

    private ReviewAdapter mReviewAdapter;
    private CastAdapter mCastAdapter;
    private FragmentDetailBinding mBinding;
    private DetailFragmentViewModel mViewModel;
    private MovieAdapter mMovieAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mBinding = FragmentDetailBinding.inflate(inflater, container, false);
        int movieId = DetailFragmentArgs.fromBundle(getArguments()).getMovieId();

        mViewModel = new ViewModelProvider(this,
                        InjectorUtils.provideDetailFragmentViewModelFactory(getContext(), movieId))
                .get(DetailFragmentViewModel.class);

        mBinding.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigateUp();
            }
        });

        subscribeUi();

        mMovieAdapter = new MovieAdapter(this);
        mReviewAdapter = new ReviewAdapter();
        mCastAdapter = new CastAdapter();
        mBinding.rvRecommendations.setAdapter(mMovieAdapter);
        mBinding.rvReviews.setAdapter(mReviewAdapter);
        mBinding.rvActors.setAdapter(mCastAdapter);

        setCallback();

        return mBinding.getRoot();
    }

    private void setCallback(){
        Callback callback = new Callback(){
            @Override
            public void addOrDelete(Movie movie, Boolean isFavourite) {
                if(isFavourite) {
                    mViewModel.deleteFromFavourite();
                } else {
                    mViewModel.addMovieToFavourite(movie);
                }
            }
        };
        mBinding.setCallback(callback);
    }

    private void loadDetail(boolean isFavourite){
        if(isFavourite){
            mBinding.setFavouriteMovie(mViewModel.getFavouriteMovie());
        } else {
            mViewModel.getMovie().observe(getViewLifecycleOwner(), new Observer<Movie>() {
                @Override
                public void onChanged(Movie movie) {
                    mBinding.setMovie(movie);
                }
            });
        }
    }

    private void subscribeUi(){

        mViewModel.getReviews().observe(getViewLifecycleOwner(), new Observer<List<Review>>() {
            @Override
            public void onChanged(List<Review> reviews) {
                mReviewAdapter.setReviews(reviews);
            }
        });

        mViewModel.getMovies().observe(getViewLifecycleOwner(), new Observer<List<MovieDiscover>>() {
            @Override
            public void onChanged(List<MovieDiscover> movieDiscovers) {
                mMovieAdapter.clear();
                mMovieAdapter.setMovieList(movieDiscovers);
            }
        });

        mViewModel.isFavourite().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                loadDetail(aBoolean);
                mBinding.setIsFavourite(aBoolean);
            }
        });

        mViewModel.getActors().observe(getViewLifecycleOwner(), new Observer<List<Actors>>() {
            @Override
            public void onChanged(List<Actors> actors) {
                Log.i("ProblemDF", "" + actors.size());
                mCastAdapter.setActorsList(actors);
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public interface Callback {
        void addOrDelete(Movie movie, Boolean isFavourite);
    }
}
