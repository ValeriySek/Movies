package com.hfad.mymovies.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hfad.mymovies.adapters.MovieAdapter
import com.hfad.mymovies.databinding.FragmentSearchBinding
import com.hfad.mymovies.viewmodels.SearchFragmentViewModel
import java.io.UnsupportedEncodingException
import java.net.URLEncoder

class SearchFragment : Fragment() {
    
//    private val viewModel by viewModels<SearchFragmentViewModel> {
////        InjectorUtils.provideHomeViewModelFactory()
//    }
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var binding: FragmentSearchBinding
    private lateinit var viewModel: SearchFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(SearchFragmentViewModel::class.java)
        movieAdapter = MovieAdapter(this)
        binding.rvSearch.adapter = movieAdapter
        setListeners()
        return binding.root
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