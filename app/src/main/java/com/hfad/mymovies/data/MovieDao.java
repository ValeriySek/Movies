package com.hfad.mymovies.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.hfad.mymovies.data.models.FavouriteMovie;
import com.hfad.mymovies.data.models.MovieDiscover;

import java.util.List;

@Dao
public interface MovieDao {

    @Query("SELECT * FROM favourite_movies")
    LiveData<List<FavouriteMovie>> getAllFavouriteMovies();

    @Query("SELECT * FROM favourite_movies WHERE id == :movieId")
    FavouriteMovie getFavouriteMovieById(int movieId);

    @Query("SELECT EXISTS(SELECT 1 FROM favourite_movies WHERE id = :movieId LIMIT 1)")
    LiveData<Boolean> isFavourite(int movieId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFavouriteMovie(FavouriteMovie movie);

    @Delete
    void deleteFavouriteMovie(FavouriteMovie movie);
}
