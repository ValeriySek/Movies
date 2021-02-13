package com.hfad.mymovies.features.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.palette.graphics.Palette
import androidx.viewbinding.ViewBinding
import com.hfad.mymovies.Application
import com.hfad.mymovies.features.MainActivity
import com.hfad.mymovies.features.adapters.CastAdapter
import com.hfad.mymovies.features.adapters.MovieAdapter
import com.hfad.mymovies.features.adapters.ReviewAdapter
import com.hfad.mymovies.features.data.models.Movie
import com.hfad.mymovies.databinding.FragmentDetailBinding
import com.hfad.mymovies.core.di.ViewModelFactory
import com.hfad.mymovies.core.platform.BaseFragment
import com.hfad.mymovies.core.utils.NetworkUtilsConstants
import com.squareup.picasso.Picasso
import jp.wasabeef.blurry.Blurry
import javax.inject.Inject

class DetailFragment : BaseFragment() {

    private var _binding : FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private var reviewAdapter: ReviewAdapter? = null
    private var castAdapter: CastAdapter? = null

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var viewModel: DetailFragmentViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)[DetailFragmentViewModel::class.java]

        val movieId = DetailFragmentArgs.fromBundle(requireArguments()).movieId
        viewModel.movieId = movieId
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAll()
        binding.detailFragmentBackArrowIv.setOnClickListener { Navigation.findNavController(it).navigateUp() }
    }

    private fun initAll() {
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
        var color= 0
        var bodycolor= 0
        if (isFavourite) {
//            binding.setFavouriteMovie(mViewModel.getFavouriteMovie());
        } else {
            viewModel.movie.observe(viewLifecycleOwner, { movie ->
                val url = NetworkUtilsConstants.BASE_POSTER_URL + NetworkUtilsConstants.BIG_POSTER_SIZE + movie.posterPath

//                val bitmap = Picasso.get().load(url).get()


                Picasso.get().load(url).apply {
                    into(binding.detailFragmentPosterIv)
                    viewModel.loadBitmap(url)
                }

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

        viewModel.bitmap.observe(viewLifecycleOwner, {
            Blurry.with(context)
                    .radius(25)
                    .sampling(5)
                    .async()
                    .from(it)
                    .into(binding.detailFragmentPosterBgIv)


            val palette = Palette.Builder(it).generate()
            color = palette.lightVibrantSwatch?.titleTextColor ?: 0
            Log.i("TAGG", "$color")
            color = palette.vibrantSwatch?.titleTextColor ?: 0
            Log.i("TAGG", "$color")
            color = palette.dominantSwatch?.titleTextColor ?: 0
            bodycolor = palette.dominantSwatch?.bodyTextColor ?: 0
            Log.i("TAGG", "$color")
            binding.detailFragmentOverviewTv.setTextColor(bodycolor)
            binding.detailFragmentTitle2Tv.setTextColor(color)
            binding.detailFragmentTitleOriginalTv.setTextColor(bodycolor)
            binding.detailFragmentGenreTv.setTextColor(color)

        })
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

    interface Callback {
        fun addOrDelete(movie: Movie?, isFavourite: Boolean)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}