package com.hfad.mymovies.features.f_favourites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.hfad.mymovies.core.platform.BaseFragment
import com.hfad.mymovies.features.adapters.FavouriteMovieAdapter
import com.hfad.mymovies.databinding.FragmentFavouriteBinding

class FavouriteFragment : BaseFragment() {

    private var _binding: FragmentFavouriteBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: FavouriteMovieAdapter
    private lateinit var viewModel: FavouriteFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        return binding.root
    }

//    private fun subscribeUi() {
//        viewModel.favouriteMovies.observe(viewLifecycleOwner, { favouriteMovies -> adapter.setMovieList(favouriteMovies) })
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        viewModel = ViewModelProvider(this
//                , InjectorUtils.provideFavouriteFragmentViewModelFactory(context)
        )
                .get(FavouriteFragmentViewModel::class.java)
        adapter = FavouriteMovieAdapter()
//        subscribeUi()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvFavouriteMovies.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}