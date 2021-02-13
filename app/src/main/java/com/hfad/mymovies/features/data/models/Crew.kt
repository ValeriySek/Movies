package com.hfad.mymovies.features.data.models

import com.google.gson.annotations.SerializedName

data class Crew(
        @SerializedName("credit_id")
        var creditId: String? = null,
        @SerializedName("department")
        var department: String? = null,
        @SerializedName("gender")
        var gender: Int = 0,
        @SerializedName("id")
        var id: Int = 0,
        @SerializedName("job")
        var job: String? = null,
        @SerializedName("name")
        var name: String? = null,
        @SerializedName("profile_path")
        var profilePath: Any? = null
)