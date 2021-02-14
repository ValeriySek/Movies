package com.hfad.mymovies.core.network.models

import com.google.gson.annotations.SerializedName
import com.hfad.mymovies.core.domain.Crew
import com.hfad.mymovies.core.network.Transformable
import com.hfad.mymovies.core.utils.EMPTY_STRING

data class CrewResponse(
        @SerializedName("credit_id") val creditId: String?,
        @SerializedName("department") val department: String?,
        @SerializedName("gender") val gender: Int?,
        @SerializedName("id") val id: Int?,
        @SerializedName("job") val job: String?,
        @SerializedName("name") val name: String?,
        @SerializedName("profile_path") val profilePath: String?
) : Transformable<Crew> {

        override fun transform(): Crew {
                return Crew(
                        creditId ?: EMPTY_STRING,
                        department ?: EMPTY_STRING,
                        gender ?: 0,
                        id ?: 0,
                        job ?: EMPTY_STRING,
                        name ?: EMPTY_STRING,
                        profilePath ?: EMPTY_STRING
                )
        }

}