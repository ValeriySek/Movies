package com.hfad.mymovies.features.f_details

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hfad.mymovies.core.domain.Actors
import com.hfad.mymovies.core.domain.MovieDetailed
import com.hfad.mymovies.core.domain.Movies
import com.hfad.mymovies.core.domain.Review
import com.hfad.mymovies.features.data.MovieRepository
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class DetailFragmentViewModel @Inject constructor(
        private val movieRepository: MovieRepository
//        favouriteMovieRepository: FavouriteMovieRepository,
) : ViewModel() {

    var movieId: Int = 0
    private val language = Locale.getDefault().language
    val movie: LiveData<MovieDetailed>
        get() = movieRepository.getMovie(movieId, language)

    var bitmap = MutableLiveData<Bitmap>()

//    fun addMovieToFavourite(movie: Movie) {
//        mFavouriteMovieRepository.addMovieToFavourite(movie)
//    }

//    fun deleteFromFavourite() {
//        mFavouriteMovieRepository.deleteFavouriteMovie(
//                mFavouriteMovieRepository.getFavouriteMovieById(mMovieId))
//    }

    //    val isFavourite: LiveData<Boolean>
//        get() = mFavouriteMovieRepository.isFavourite(mMovieId)
    val actors: LiveData<List<Actors>>
        get() = movieRepository.getActors(movieId, language)
    val movies: LiveData<List<Movies>>
        get() = movieRepository.getRecommended(1, movieId, language)

    //    val favouriteMovie: FavouriteMovie
//        get() = mFavouriteMovieRepository.getFavouriteMovieById(mMovieId)
    val reviews: LiveData<List<Review>>
        get() = movieRepository.getReviews(movieId, language)

//    init {
//        this.movieRepository = movieRepository
//        mFavouriteMovieRepository = favouriteMovieRepository
//        mMovieId = movieId
//    }

    fun loadBitmap(url: String){
        viewModelScope.launch(Dispatchers.IO) {
            bitmap.postValue(Picasso.get().load(url).get())
        }
    }
}