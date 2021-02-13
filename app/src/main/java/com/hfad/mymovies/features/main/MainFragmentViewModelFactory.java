package com.hfad.mymovies.features.main;

//public class MainFragmentViewModelFactory extends ViewModelProvider.NewInstanceFactory {
//
//    private MovieRepository mRepository;
//
//    public MainFragmentViewModelFactory(MovieRepository repository) {
//        mRepository = repository;
//    }
//
//    @NonNull
//    @Override
//    @SuppressWarnings("unchecked")
//    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
//        if(modelClass.isAssignableFrom(MainFragmentViewModel.class)){
//            return (T) new MainFragmentViewModel(mRepository);
//        } else {
//            throw new IllegalArgumentException("Wrong class");
//        }
//    }
//}
