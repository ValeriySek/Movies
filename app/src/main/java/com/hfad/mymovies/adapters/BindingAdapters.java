package com.hfad.mymovies.adapters;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.databinding.BindingAdapter;

import com.hfad.mymovies.data.models.Genre;
import com.hfad.mymovies.utils.NetworkUtilsConstants;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BindingAdapters {

    @BindingAdapter("loadSmallImage")
    public static void loadImageFromUrl(ImageView view, String imageUrl){
        if(imageUrl != null && !imageUrl.isEmpty()){
            String url = NetworkUtilsConstants.BASE_POSTER_URL + NetworkUtilsConstants.SMALL_POSTER_SIZE + imageUrl;
            Picasso.get().load(url).into(view);
        }
    }

    @BindingAdapter("loadBigImage")
    public static void loadBigImg(ImageView view, String bigUrl){
        if(bigUrl != null && !bigUrl.isEmpty()){
            String url =  NetworkUtilsConstants.BASE_POSTER_URL + NetworkUtilsConstants.BIG_POSTER_SIZE + bigUrl;
                    Picasso.get().load(url).into(view);
        }
    }
    @BindingAdapter("loadMediumImage")
    public static void loadMediumImg(ImageView view, String bigUrl){
        if(bigUrl != null && !bigUrl.isEmpty()){
            String url =  NetworkUtilsConstants.BASE_POSTER_URL + NetworkUtilsConstants.MEDIUM_POSTER_SIZE + bigUrl;
            Picasso.get().load(url).into(view);
        }
    }

    @BindingAdapter("isGone")
    public static void isGone(View view, Boolean isGone){
        view.setVisibility(isGone ? View.INVISIBLE : View.INVISIBLE);
    }

    @BindingAdapter("loadVideo")
    public static void loadVideo(VideoView view, String url){

    }

    @BindingAdapter("getGenres")
    public static void getGenres(TextView view, List<Genre> genres){
        Log.i("Genress", "" + genres);
        if(genres == null) return;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < genres.size(); i++){
            stringBuilder.append(genres.get(i).getName());
            if(i < genres.size() - 1){
                stringBuilder.append(" - ");
            }
        }
        view.setText(stringBuilder);
    }
}
