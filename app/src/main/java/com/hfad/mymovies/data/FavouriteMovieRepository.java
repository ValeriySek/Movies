package com.hfad.mymovies.data;

//import android.os.AsyncTask;
//import android.util.Log;
//
//import androidx.lifecycle.LiveData;
//
//import com.hfad.mymovies.data.models.FavouriteMovie;
//import com.hfad.mymovies.data.models.Movie;
//
//import java.util.List;
//import java.util.concurrent.ExecutionException;
//
//public class FavouriteMovieRepository {
//
//    private static FavouriteMovieRepository sFavouriteMovieRepository;
//    private static MovieDao mMovieDao;
//
//    private FavouriteMovieRepository(MovieDao movieDao){
//        mMovieDao = movieDao;
//    }
//
//    public static FavouriteMovieRepository getInstance(MovieDao movieDao){
//        if(sFavouriteMovieRepository == null){
//            sFavouriteMovieRepository = new FavouriteMovieRepository(movieDao);
//        }
//        return sFavouriteMovieRepository;
//    }
//
//    public void addMovieToFavourite(Movie movie){
//        Log.i("ProblemFMRadd", "" + movie.getTitle());
//        new InsertFavouriteTask().execute(new FavouriteMovie(movie));
//    }
//
//    private static class InsertFavouriteTask extends AsyncTask<FavouriteMovie, Void, Void> {
//
//        @Override
//        protected Void doInBackground(FavouriteMovie... movies) {
//            if (movies != null && movies.length > 0) {
//                mMovieDao.insertFavouriteMovie(movies[0]);
//            }
//            return null;
//        }
//    }
//    public void deleteFavouriteMovie(FavouriteMovie movie){
//        new DeleteFavouriteTask().execute(movie);
//    }
//
//    private static class DeleteFavouriteTask extends AsyncTask<FavouriteMovie, Void, Void> {
//
//        @Override
//        protected Void doInBackground(FavouriteMovie... movies) {
//            if (movies != null && movies.length > 0) {
//                mMovieDao.deleteFavouriteMovie(movies[0]);
//            }
//            return null;
//        }
//    }
//
//    public FavouriteMovie getFavouriteMovieById(int id){
//        try {
//            return new GetFavouriteMovieTask().execute(id).get();
//        } catch (ExecutionException | InterruptedException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    private static class GetFavouriteMovieTask extends AsyncTask<Integer, Void, FavouriteMovie> {
//
//        @Override
//        protected FavouriteMovie doInBackground(Integer... integers) {
//            if (integers != null && integers.length > 0) {
//                return mMovieDao.getFavouriteMovieById(integers[0]);
//            }
//            return null;
//        }
//    }
//
//    public LiveData<List<FavouriteMovie>> getFavouriteMovies(){
//        return mMovieDao.getAllFavouriteMovies();
//    }
//
//    public LiveData<Boolean> isFavourite(int movieId){
//        return mMovieDao.isFavourite(movieId);
//    }
//}
