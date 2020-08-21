package com.hfad.mymovies.api;

import com.hfad.mymovies.data.models.ExampleResponse;
import com.hfad.mymovies.data.models.ExampleReview;
import com.hfad.mymovies.data.models.Movie;
import com.hfad.mymovies.data.models.MovieDiscover;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("discover/movie?api_key=756d1951529fd2f2bc0df1846271d514&include_adult=false&include_video=false}")
    Observable<ExampleResponse> getExample(@Query("language") String language,@Query("page") int page, @Query("sort_by") String sort, @Query("vote_count.gte") int count);

    @GET("movie/{movie_id}?api_key=756d1951529fd2f2bc0df1846271d514")
    Observable<Movie> getExampleMovie(@Path("movie_id") int movieId, @Query("language") String language);

    @GET("movie/{movie_id}/credits?api_key=756d1951529fd2f2bc0df1846271d514")
    Observable<ExampleResponse> getCast(@Path("movie_id") int movieId, @Query("language") String language);

    @GET("search/movie?api_key=756d1951529fd2f2bc0df1846271d514")
    Observable<ExampleResponse> getSearchMovies(@Query("language") String language, @Query("query") String name);

    @GET("movie/{movie_id}/recommendations?api_key=756d1951529fd2f2bc0df1846271d514&include_adult=false&include_video=false}")
    Observable<ExampleResponse> getRecommended(@Path("movie_id") int movieId, @Query("language") String language,@Query("page") int page);

    @GET("movie/upcoming?api_key=756d1951529fd2f2bc0df1846271d514")
    Observable<ExampleResponse> getUpcoming(@Query("language") String language, @Query("page") int page);


    @GET("movie/{movie_id}/reviews?api_key=756d1951529fd2f2bc0df1846271d514")
    Observable<ExampleReview> getReviews(@Path("movie_id") int movieId, @Query("language") String language);
}
