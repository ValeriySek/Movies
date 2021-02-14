package com.hfad.mymovies.core.domain

import com.hfad.mymovies.core.utils.EMPTY_STRING

data class Crew(
        var creditId: String = EMPTY_STRING,
        var department: String = EMPTY_STRING,
        var gender: Int = 0,
        var id: Int = 0,
        var job: String = EMPTY_STRING,
        var name: String = EMPTY_STRING,
        var profilePath: String? = EMPTY_STRING
)