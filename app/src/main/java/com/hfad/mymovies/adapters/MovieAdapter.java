package com.hfad.mymovies.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.mymovies.ui.FavouriteFragmentDirections;
import com.hfad.mymovies.ui.MainFragmentDirections;
import com.hfad.mymovies.R;
import com.hfad.mymovies.data.models.MovieDiscover;
import com.hfad.mymovies.databinding.MovieItemBinding;
import com.hfad.mymovies.ui.DetailFragmentDirections;
import com.hfad.mymovies.ui.SearchFragmentDirections;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {


    private List<MovieDiscover> movieList = new ArrayList<>();
    private OnReachEndListener onReachEndListener;
    private Fragment mFragment;

    public MovieAdapter(Fragment fragment) {
        mFragment = fragment;
        Log.i("ProblemMAAA", "" + fragment.toString());
    }

    public void clear(){
        movieList.clear();
        notifyDataSetChanged();
    }

    public interface OnReachEndListener{
        void onReachEnd();
    }

    public void setOnReachEndListener(OnReachEndListener onReachEndListener) {
        this.onReachEndListener = onReachEndListener;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        MovieItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.movie_item, parent, false);
        return new MovieHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        if (position > movieList.size() - 2 && onReachEndListener != null){
            onReachEndListener.onReachEnd();
        }
        holder.bind(movieList.get(position));

    }

    @Override
    public int getItemCount() {
        return movieList == null ? 0 : movieList.size();
    }

    public void setMovieList(List<MovieDiscover> movieList) {
        this.movieList = movieList;
        Log.i("LoadSearchA", "" + movieList.size());
        notifyDataSetChanged();
    }

     class MovieHolder extends RecyclerView.ViewHolder{

        MovieItemBinding mBinding;

        MovieHolder(MovieItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;

            binding.setClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NavDirections directions = chooseDirection();
                    Navigation.findNavController(view).navigate(directions);
                }
            });
        }

        private NavDirections chooseDirection(){
            if(mFragment.toString().contains("MainFragment")) {
                return MainFragmentDirections
                        .actionMainActivityToDetailActivity2(mBinding.getMovieDiscover().getId());
            }else if (mFragment.toString().contains("FavouriteFragment")){
                return FavouriteFragmentDirections
                        .actionFavouriteFragmentToDetailFragment(mBinding.getMovieDiscover().getId());
            } else if (mFragment.toString().contains("SearchFragment")){
                return SearchFragmentDirections
                        .actionHomeFragmentToDetailFragment(mBinding.getMovieDiscover().getId());
            } else {
                return DetailFragmentDirections
                        .actionDetailFragmentSelf(mBinding.getMovieDiscover().getId());
            }
        }

        void bind(MovieDiscover movieDiscover){
            mBinding.setMovieDiscover(movieDiscover);
            mBinding.executePendingBindings();
        }
    }
}
