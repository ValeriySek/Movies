package com.hfad.mymovies.utils

object NetworkUtilsConstants {
    private const val BASE_URL = "https://api.themoviedb.org/3/discover/movie"
    private const val BASE_URL_VIDEOS = "https://api.themoviedb.org/3/movie/%s/videos"
    private const val BASE_URL_REVIEWS = "https://api.themoviedb.org/3/movie/%s/reviews"
    private const val API_KEY = "756d1951529fd2f2bc0df1846271d514"
    const val SORT_BY_POPULARITY = "popularity.desc"
    const val SORT_BY_TOP_RATED = "vote_average.desc"
    const val SORT_BY_NAME = "original_title.asc"
    const val SORT_BY_DATE = "primary_release_date.desc"
    const val UPCOMING = "upcoming"
    const val BASE_YOUTUBE_URL = "https://www.youtube.com/watch?v="
    const val BASE_POSTER_URL = "https://image.tmdb.org/t/p/"
    const val SMALL_POSTER_SIZE = "w185"
    const val MEDIUM_POSTER_SIZE = "w342"
    const val BIG_POSTER_SIZE = "w500"
}