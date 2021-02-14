package com.hfad.mymovies.features.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hfad.mymovies.core.network.models.FavouriteMovie

@Dao
interface MovieDao {
    @get:Query("SELECT * FROM favourite_movies")
    val allFavouriteMovies: LiveData<List<FavouriteMovie?>?>?

    @Query("SELECT * FROM favourite_movies WHERE id == :movieId")
    fun getFavouriteMovieById(movieId: Int): FavouriteMovie?

    @Query("SELECT EXISTS(SELECT 1 FROM favourite_movies WHERE id = :movieId LIMIT 1)")
    fun isFavourite(movieId: Int): LiveData<Boolean?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavouriteMovie(movie: FavouriteMovie?)

    @Delete
    fun deleteFavouriteMovie(movie: FavouriteMovie?)
}