package com.hfad.mymovies.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hfad.mymovies.data.MovieRepository
import com.hfad.mymovies.data.models.Actors
import com.hfad.mymovies.data.models.Movie
import com.hfad.mymovies.data.models.MovieDiscover
import com.hfad.mymovies.data.models.Review
import java.util.*
import javax.inject.Inject

class DetailFragmentViewModel @Inject constructor(
        private val movieRepository: MovieRepository
//        favouriteMovieRepository: FavouriteMovieRepository,
) : ViewModel() {

    var movieId: Int = 0
    private val language = Locale.getDefault().language
    val movie: LiveData<Movie>
        get() = movieRepository.getMovie(movieId, language)

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
    val movies: LiveData<MutableList<MovieDiscover>>
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
}