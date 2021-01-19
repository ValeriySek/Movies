package com.hfad.mymovies.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hfad.mymovies.data.models.FavouriteMovie
import com.hfad.mymovies.databinding.FavouriteMovieItemBinding
import com.hfad.mymovies.utils.NetworkUtilsConstants
import com.squareup.picasso.Picasso
import java.util.*

class FavouriteMovieAdapter : RecyclerView.Adapter<FavouriteMovieAdapter.MovieHolder>() {
    private var movieList: MutableList<FavouriteMovie>? = ArrayList()
    fun clear() {
        movieList!!.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FavouriteMovieItemBinding.inflate(inflater, parent, false)
        return MovieHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(movieList!![position])
    }

    override fun getItemCount(): Int {
        return if (movieList == null) 0 else movieList!!.size
    }

    fun setMovieList(movieList: MutableList<FavouriteMovie>) {
        this.movieList = movieList
        Log.i("LoadSearchA", "" + movieList.size)
        notifyDataSetChanged()
    }

    inner class MovieHolder     //            binding.setClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    NavDirections directions = chooseDirection();
//                    Navigation.findNavController(view).navigate(directions);
//                }
//            });
    (var binding: FavouriteMovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        //        private NavDirections chooseDirection(){
        //                return FavouriteFragmentDirections
        //                        .actionFavouriteFragmentToDetailFragment(mBinding.getFavouriteMovie().getId());
        //        }
        fun bind(favouriteMovie: FavouriteMovie) {
            val url = NetworkUtilsConstants.BASE_POSTER_URL + NetworkUtilsConstants.SMALL_POSTER_SIZE + favouriteMovie.posterPath
            Picasso.get().load(url).into(binding.itemFavouriteMovieSmallPosterIv)
            binding.detailFragmentTitle2Tv.text = favouriteMovie.title
            binding.itemFavouriteMovieReleaseDateTv.text = favouriteMovie.releaseDate.substring(0, 4)
            binding.itemFavouriteMovieRatingBar.rating = favouriteMovie.voteAverage.toFloat()
        }
    }
}