package com.hfad.mymovies.utils;

public class NetworkUtilsConstants {

    private static final String BASE_URL = "https://api.themoviedb.org/3/discover/movie";
    private static final String BASE_URL_VIDEOS = "https://api.themoviedb.org/3/movie/%s/videos";
    private static final String BASE_URL_REVIEWS = "https://api.themoviedb.org/3/movie/%s/reviews";

    private static final String API_KEY = "756d1951529fd2f2bc0df1846271d514";
    public static final String SORT_BY_POPULARITY = "popularity.desc";
    public static final String SORT_BY_TOP_RATED = "vote_average.desc";
    public static final String SORT_BY_NAME = "original_title.asc";
    public static final String SORT_BY_DATE = "primary_release_date.desc";
    public static final String UPCOMING = "upcoming";

    public static final String BASE_YOUTUBE_URL = "https://www.youtube.com/watch?v=";

    public static final String BASE_POSTER_URL = "https://image.tmdb.org/t/p/";
    public static final String SMALL_POSTER_SIZE = "w185";
    public static final String MEDIUM_POSTER_SIZE = "w342";
    public static final String BIG_POSTER_SIZE = "w500";

}
