package com.hfad.mymovies.features.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.hfad.mymovies.core.network.models.FavouriteMovie;
import com.hfad.mymovies.core.network.models.MoviesResponse;

@Database(entities = {MoviesResponse.class, FavouriteMovie.class}, version = 9, exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {
    private static final String DB_NAME = "movies.db";

    private static MovieDatabase database;
    private static final Object LOCK = new Object();

    public static MovieDatabase getInstance(Context context){
        synchronized (LOCK) {
            if (database == null) {
                database = Room.databaseBuilder(context, MovieDatabase.class, DB_NAME)
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return database;
    }

    public abstract MovieDao movieDao();
}
