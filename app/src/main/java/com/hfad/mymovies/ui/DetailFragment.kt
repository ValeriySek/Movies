package com.hfad.mymovies.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.hfad.mymovies.Application
import com.hfad.mymovies.MainActivity
import com.hfad.mymovies.adapters.CastAdapter
import com.hfad.mymovies.adapters.MovieAdapter
import com.hfad.mymovies.adapters.ReviewAdapter
import com.hfad.mymovies.data.models.Movie
import com.hfad.mymovies.databinding.FragmentDetailBinding
import com.hfad.mymovies.di.ViewModelFactory
import com.hfad.mymovies.utils.NetworkUtilsConstants
import com.hfad.mymovies.viewmodels.DetailFragmentViewModel
import com.squareup.picasso.Picasso
import javax.inject.Inject

class DetailFragment : Fragment() {

    private var reviewAdapter: ReviewAdapter? = null
    private var castAdapter: CastAdapter? = null
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var viewModel: DetailFragmentViewModel
    private lateinit var binding: FragmentDetailBinding
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        ((activity as MainActivity).application as Application).appComponentFactory.inject(this)
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory)[DetailFragmentViewModel::class.java]
        val movieId = DetailFragmentArgs.fromBundle(requireArguments()).movieId
        viewModel.movieId = movieId
        initAll()
        binding.detailFragmentBackArrowIv.setOnClickListener { view -> Navigation.findNavController(view).navigateUp() }
        return binding.root
    }

    private fun initAll(){
        subscribeUi()
        initAdapters()
        loadDetail(false)
        setCallback()
    }

    private fun initAdapters() {
        movieAdapter = MovieAdapter(this)
        reviewAdapter = ReviewAdapter()
        castAdapter = CastAdapter()
        binding.detailFragmentRecommendationsRv.adapter = movieAdapter
        binding.detailFragmentReviewsRv.adapter = reviewAdapter
        binding.detailFragmentActorsRv.adapter = castAdapter
    }

    private fun setCallback() {
//        val callback: Callback = object : Callback {
//            override fun addOrDelete(movie: Movie?, isFavourite: Boolean) {
//                if (isFavourite) {
//                    viewModel.deleteFromFavourite()
//                } else {
//                    viewModel.addMovieToFavourite(movie)
//                }
//            }
//        }
        //        binding.setCallback(callback);
    }

    private fun loadDetail(isFavourite: Boolean) {
        if (isFavourite) {
//            binding.setFavouriteMovie(mViewModel.getFavouriteMovie());
        } else {
            viewModel.movie.observe(viewLifecycleOwner, { movie ->
                val url = NetworkUtilsConstants.BASE_POSTER_URL + NetworkUtilsConstants.BIG_POSTER_SIZE + movie.posterPath
                Picasso.get().load(url).into(binding.detailFragmentPosterIv)
                binding.detailFragmentTitle2Tv.text = movie.title
                binding.detailFragmentTitleOriginalTv.text = movie.originalTitle
                val stringBuilder = StringBuilder()
                for (i in movie.genres.indices) {
                    stringBuilder.append(movie.genres[i].name)
                    if (i < movie.genres.size - 1) {
                        stringBuilder.append(" - ")
                    }
                }
                binding.detailFragmentGenreTv.text = stringBuilder
                binding.detailFragmentRatingTv.text = movie.voteAverage.toString()
                binding.detailFragmentReleaseDateTv.text = movie.releaseDate
                binding.detailFragmentOverviewTv.text = movie.overview
            })
        }
    }

    private fun subscribeUi() {
        viewModel.reviews.observe(viewLifecycleOwner, { reviews -> reviewAdapter!!.setReviews(reviews) })
        viewModel.movies.observe(viewLifecycleOwner, { movieDiscovers ->
            movieAdapter.clear()
            movieAdapter.setMovieList(movieDiscovers)
        })
//        viewModel.isFavourite.observe(viewLifecycleOwner, { aBoolean ->
//            loadDetail(aBoolean)
//                            binding.setIsFavourite(aBoolean);
//        })
        viewModel.actors.observe(viewLifecycleOwner, { actors ->
            Log.i("ProblemDF", "" + actors.size)
            castAdapter!!.setActorsList(actors)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    interface Callback {
        fun addOrDelete(movie: Movie?, isFavourite: Boolean)
    }
}