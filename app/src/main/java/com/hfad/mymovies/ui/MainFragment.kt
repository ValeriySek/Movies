package com.hfad.mymovies.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hfad.mymovies.Application
import com.hfad.mymovies.MainActivity
import com.hfad.mymovies.adapters.MovieAdapter
import com.hfad.mymovies.databinding.FragmentMainBinding
import com.hfad.mymovies.di.ViewModelFactory
import com.hfad.mymovies.route.SimpleBottomSheetDialogRoute
import com.hfad.mymovies.route.dialog.SimpleBottomSheetDialogView
import com.hfad.mymovies.route.navigator.DialogNavigator
import com.hfad.mymovies.viewmodels.MainFragmentViewModel
import javax.inject.Inject

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var viewModel: MainFragmentViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        ((activity as MainActivity).application as Application).appComponentFactory.inject(this)
        binding = FragmentMainBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainFragmentViewModel::class.java]
        movieAdapter = MovieAdapter(this)
        binding.recyclerViewPosters.adapter = movieAdapter
        binding.button.setOnClickListener { DialogNavigator().show(SimpleBottomSheetDialogRoute(), activity as MainActivity) }
        loadData()
        setCallback()
        setListeners()
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun setCallback() {
        val callback: Callback = object : Callback {
            override fun checkedChip(sort: String?) {
                movieAdapter.clear()
                viewModel.setFirstPage()
                viewModel.setMethodOfSort(sort)
                loadData()
            }
        }

//        binding.setCallback(callback);
    }

    private fun setListeners() {
        movieAdapter.setOnReachEndListener(object : MovieAdapter.OnReachEndListener {
            override fun onReachEnd() {
                viewModel.increasePage()
                loadData()
            }
        })
    }

    private fun loadData() {
        viewModel.movieList.observe(viewLifecycleOwner, { movieDiscovers -> movieAdapter.setMovieList(movieDiscovers) })
    }

    interface Callback {
        fun checkedChip(sort: String?)
    }
}