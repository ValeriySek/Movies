package com.hfad.mymovies.features.data.models

import com.google.gson.annotations.SerializedName

data class Actors (
    @SerializedName("cast_id")
    var castId: Int = 0,
    @SerializedName("character")
    var character: String? = null,
    @SerializedName("credit_id")
    var creditId: String? = null,
    @SerializedName("gender")
    var gender: Int = 0,
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("order")
    var order: Int = 0,
    @SerializedName("profile_path")
    val profilePath: String? = null,
        //    public void setProfilePath(String profilePath) {
    //        this.profilePath = profilePath;
    //    }
)