package com.hfad.mymovies.features.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hfad.mymovies.core.di.ViewModelFactory
import com.hfad.mymovies.core.platform.BaseFragment
import com.hfad.mymovies.features.adapters.MovieAdapter
import com.hfad.mymovies.databinding.FragmentSearchBinding
import java.io.UnsupportedEncodingException
import java.net.URLEncoder
import javax.inject.Inject

class SearchFragment : BaseFragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!


//    private val viewModel by viewModels<SearchFragmentViewModel> {
////        InjectorUtils.provideHomeViewModelFactory()
//    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: SearchFragmentViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[SearchFragmentViewModel::class.java]
        movieAdapter = MovieAdapter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvSearch.adapter = movieAdapter
        setListeners()
    }

    private fun setListeners() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                var encoder = ""
                try {
                    encoder = URLEncoder.encode(query, "UTF-8")
                } catch (e: UnsupportedEncodingException) {
                    e.printStackTrace()
                }
                loadData(encoder)
                Toast.makeText(context, "$query $encoder".trimIndent(), Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
    }

    private fun loadData(name: String) {
        viewModel.searchMovie(name).observe(viewLifecycleOwner, Observer { movieDiscovers ->
            Log.i("LoadSearch", "" + movieDiscovers)
            movieAdapter.setMovieList(movieDiscovers)
        })
    }
}