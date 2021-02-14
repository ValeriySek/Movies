package com.hfad.mymovies.core.network.models

import com.google.gson.annotations.SerializedName
import com.hfad.mymovies.core.domain.Actors
import com.hfad.mymovies.core.network.Transformable
import com.hfad.mymovies.core.utils.EMPTY_STRING

data class ActorsResponse (
    @SerializedName("cast_id") val castId: Int?,
    @SerializedName("character") val character: String?,
    @SerializedName("credit_id") val creditId: String?,
    @SerializedName("gender") val gender: Int?,
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("order") val order: Int?,
    @SerializedName("profile_path") val profilePath: String?
        //    public void setProfilePath(String profilePath) {
    //        this.profilePath = profilePath;
    //    }
) : Transformable<Actors> {

    override fun transform(): Actors {
        return Actors(
                castId ?: 0,
                character ?: EMPTY_STRING,
                creditId ?: EMPTY_STRING,
                gender ?: 0,
                id ?: 0,
                name ?: EMPTY_STRING,
                order ?: 0,
                profilePath ?: EMPTY_STRING
        )
    }

}