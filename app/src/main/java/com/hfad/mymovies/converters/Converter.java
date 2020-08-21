package com.hfad.mymovies.converters;

import android.util.Log;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.hfad.mymovies.data.models.Genre;

import java.lang.reflect.GenericSignatureFormatError;
import java.util.ArrayList;
import java.util.List;

public class Converter {

    @TypeConverter
    public String genreListToString(List<Genre> genres){
        return new Gson().toJson(genres);
    }

    @TypeConverter
    public List<Genre> stringToGenreList(String gengesAsString){
        Gson gson = new Gson();
        ArrayList arrayList = gson.fromJson(gengesAsString, ArrayList.class);
        ArrayList<Genre> genres = new ArrayList<>();
        for(Object o : arrayList){
            genres.add(gson.fromJson(o.toString(), Genre.class));
        }
        return genres;
    }

    @TypeConverter
    public String integersToString(List<Integer> integers){
//        Log.i("Converter",  integers.toString());
        String s = "";
        if(integers == null){
            return s;
        }
        for (Integer i : integers) {
            s += i + " ";
        }
        return s;
    }

    @TypeConverter
    public List<Integer> stringToInteger(String intAsString){
        Log.i("Converter", intAsString);
        if(intAsString.equals("")){
            return null;
        }
        String[] strings = intAsString.split(" ");
        ArrayList<Integer> integers = new ArrayList<>();
        for(String s : strings){
            integers.add(Integer.parseInt(s));
        }
        return integers;
    }
}
