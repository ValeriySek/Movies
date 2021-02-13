package com.hfad.mymovies.features.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hfad.mymovies.Application
import com.hfad.mymovies.features.MainActivity
import com.hfad.mymovies.features.adapters.MovieAdapter
import com.hfad.mymovies.databinding.FragmentMainBinding
import com.hfad.mymovies.core.di.ViewModelFactory
import com.hfad.mymovies.core.platform.BaseFragment
import com.hfad.mymovies.core.route.SimpleBottomSheetDialogRoute
import com.hfad.mymovies.core.route.navigator.DialogNavigator
import javax.inject.Inject

class MainFragment : BaseFragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var viewModel: MainFragmentViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)[MainFragmentViewModel::class.java]
        movieAdapter = MovieAdapter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewPosters.adapter = movieAdapter
        binding.button.setOnClickListener { DialogNavigator().show(SimpleBottomSheetDialogRoute(), activity as MainActivity) }
        loadData()
        setCallback()
        setListeners()
        setHasOptionsMenu(true)
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