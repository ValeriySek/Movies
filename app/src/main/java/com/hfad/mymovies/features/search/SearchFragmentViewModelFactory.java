package com.hfad.mymovies.features.search;

//public class SearchFragmentViewModelFactory extends ViewModelProvider.NewInstanceFactory {
//
//
//    private MovieRepository mRepository;
//
//    public SearchFragmentViewModelFactory(MovieRepository repository) {
//        mRepository = repository;
//    }
//
//    @SuppressWarnings("unchecked")
//    @NonNull
//    @Override
//    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
//        if(modelClass.isAssignableFrom(SearchFragmentViewModel.class)){
//            return (T) new SearchFragmentViewModel(mRepository);
//        }else {
//            throw new IllegalArgumentException("Wrong class");
//        }
//    }
//}
