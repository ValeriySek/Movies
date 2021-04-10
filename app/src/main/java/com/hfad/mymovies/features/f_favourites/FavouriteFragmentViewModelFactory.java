package com.hfad.mymovies.features.f_favourites;

//import com.hfad.mymovies.data.FavouriteMovieRepository;


//public class FavouriteFragmentViewModelFactory extends ViewModelProvider.NewInstanceFactory {
//
//    private FavouriteMovieRepository mRepository;
//
//    public FavouriteFragmentViewModelFactory(FavouriteMovieRepository repository) {
//        mRepository = repository;
//    }
//
//    @SuppressWarnings("unchecked")
//    @NonNull
//    @Override
//    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
//        if(modelClass.isAssignableFrom(FavouriteFragmentViewModel.class)){
//            return (T) new FavouriteFragmentViewModel(mRepository);
//        }else {
//            throw new IllegalArgumentException("Wrong class");
//        }
//    }
//}
