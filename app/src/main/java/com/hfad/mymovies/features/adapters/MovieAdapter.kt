package com.hfad.mymovies.features.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.hfad.mymovies.features.data.models.MovieDiscover
import com.hfad.mymovies.databinding.MovieItemBinding
import com.hfad.mymovies.core.utils.NetworkUtilsConstants
import com.hfad.mymovies.features.details.DetailFragmentDirections
import com.hfad.mymovies.features.favourites.FavouriteFragmentDirections
import com.hfad.mymovies.features.main.MainFragmentDirections
import com.hfad.mymovies.features.search.SearchFragmentDirections
import com.squareup.picasso.Picasso
import java.util.*

class MovieAdapter(private val mFragment: Fragment) : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {
    private var movieList: List<MovieDiscover>? = ArrayList()
    private var onReachEndListener: OnReachEndListener? = null
    fun clear() {
        movieList = null
        notifyDataSetChanged()
    }

    interface OnReachEndListener {
        fun onReachEnd()
    }

    fun setOnReachEndListener(onReachEndListener: OnReachEndListener?) {
        this.onReachEndListener = onReachEndListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MovieItemBinding.inflate(inflater, parent, false)
        return MovieHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        if (position > movieList!!.size - 2 && onReachEndListener != null) {
            onReachEndListener!!.onReachEnd()
        }
        holder.bind(movieList!![position])
    }

    override fun getItemCount(): Int {
        return if (movieList == null) 0 else movieList!!.size
    }

    fun setMovieList(movieList: List<MovieDiscover>) {
        this.movieList = movieList
        Log.i("LoadSearchA", "" + movieList.size)
        notifyDataSetChanged()
    }

    inner class MovieHolder(var binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        private fun chooseDirection(): NavDirections {
            val id = movieList!![adapterPosition].id
            return when {
                mFragment.toString().contains("MainFragment") -> {
                    MainFragmentDirections
                            .actionMainActivityToDetailActivity2(id)
                }
                mFragment.toString().contains("FavouriteFragment") -> {
                    FavouriteFragmentDirections
                            .actionFavouriteFragmentToDetailFragment(id)
                }
                mFragment.toString().contains("SearchFragment") -> {
                    SearchFragmentDirections
                            .actionHomeFragmentToDetailFragment(id)
                }
                else -> {
                    Log.i("TAGG", "else")
                    DetailFragmentDirections
                            .actionDetailFragmentSelf(id)
                }
            }
        }

        fun bind(movieDiscover: MovieDiscover) {
            binding.itemMovieCard.setOnClickListener(this)
            val url = NetworkUtilsConstants.BASE_POSTER_URL + NetworkUtilsConstants.SMALL_POSTER_SIZE + movieDiscover.posterPath
            Log.i("TAGG", "${movieDiscover.posterPath}")
            Picasso.get().load(url).into(binding.itemMovieSmallPosterIv)
            binding.itemMovieTitle2Tv.text = movieDiscover.title
            binding.itemMovieReleaseDateTv.text = movieDiscover.releaseDate?.substring(0, 4)
            binding.itemMovieRatingBar.rating = movieDiscover.voteAverage.toFloat()
        }

        override fun onClick(view: View) {
            val directions = chooseDirection()
            Navigation.findNavController(view).navigate(directions)
        }
    }
}