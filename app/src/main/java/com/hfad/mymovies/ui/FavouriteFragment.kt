package com.hfad.mymovies.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hfad.mymovies.adapters.FavouriteMovieAdapter
import com.hfad.mymovies.databinding.FragmentFavouriteBinding
import com.hfad.mymovies.viewmodels.FavouriteFragmentViewModel

class FavouriteFragment : Fragment() {

    private lateinit var adapter: FavouriteMovieAdapter
    private lateinit var binding: FragmentFavouriteBinding
    private lateinit var viewModel: FavouriteFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this
//                , InjectorUtils.provideFavouriteFragmentViewModelFactory(context)
        )
                .get(FavouriteFragmentViewModel::class.java)
        adapter = FavouriteMovieAdapter()
        binding.rvFavouriteMovies.adapter = adapter
//        subscribeUi()
        return binding.root
    }

//    private fun subscribeUi() {
//        viewModel.favouriteMovies.observe(viewLifecycleOwner, { favouriteMovies -> adapter.setMovieList(favouriteMovies) })
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}