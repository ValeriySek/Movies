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

import com.hfad.mymovies.R;
import com.hfad.mymovies.data.models.FavouriteMovie;
import com.hfad.mymovies.data.models.MovieDiscover;
import com.hfad.mymovies.databinding.FavouriteMovieItemBinding;
import com.hfad.mymovies.databinding.MovieItemBinding;
import com.hfad.mymovies.ui.DetailFragmentDirections;
import com.hfad.mymovies.ui.FavouriteFragmentDirections;
import com.hfad.mymovies.ui.MainFragmentDirections;
import com.hfad.mymovies.ui.SearchFragmentDirections;
import com.hfad.mymovies.viewmodels.FavouriteFragmentViewModel;

import java.util.ArrayList;
import java.util.List;

public class FavouriteMovieAdapter extends RecyclerView.Adapter<FavouriteMovieAdapter.MovieHolder> {


    private List<FavouriteMovie> movieList = new ArrayList<>();

    public FavouriteMovieAdapter() {
    }

    public void clear(){
        movieList.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        FavouriteMovieItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.favourite_movie_item, parent, false);
        return new MovieHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        holder.bind(movieList.get(position));
    }

    @Override
    public int getItemCount() {
        return movieList == null ? 0 : movieList.size();
    }

    public void setMovieList(List<FavouriteMovie> movieList) {
        this.movieList = movieList;
        Log.i("LoadSearchA", "" + movieList.size());
        notifyDataSetChanged();
    }


     class MovieHolder extends RecyclerView.ViewHolder{

         FavouriteMovieItemBinding mBinding;

        MovieHolder(FavouriteMovieItemBinding binding) {
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
                return FavouriteFragmentDirections
                        .actionFavouriteFragmentToDetailFragment(mBinding.getFavouriteMovie().getId());
        }

        void bind(FavouriteMovie favouriteMovie){
            mBinding.setFavouriteMovie(favouriteMovie);
            mBinding.executePendingBindings();
        }
    }
}
