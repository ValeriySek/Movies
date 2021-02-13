package com.hfad.mymovies.features.details;

//import com.hfad.mymovies.data.FavouriteMovieRepository;


//public class DetailFragmentViewModelFactory extends ViewModelProvider.NewInstanceFactory {
//
//    private MovieRepository mMovieRepository;
//    private FavouriteMovieRepository mFavouriteMovieRepository;
//    private int mMovieId;
//
//
//    public DetailFragmentViewModelFactory(MovieRepository movieRepository, FavouriteMovieRepository favouriteMovieRepository, int movieId) {
//        mMovieRepository = movieRepository;
//        mFavouriteMovieRepository = favouriteMovieRepository;
//        mMovieId = movieId;
//    }
//
//    @SuppressWarnings("unchecked")
//    @NonNull
//    @Override
//    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
//        if(modelClass.isAssignableFrom(DetailFragmentViewModel.class)){
//            return (T) new DetailFragmentViewModel(mMovieRepository, mFavouriteMovieRepository, mMovieId);
//        } else {
//            throw new IllegalArgumentException("Wrong class");
//        }
//
//    }
//}
