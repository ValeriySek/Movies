package com.hfad.mymovies.core.utils.extentoins

import com.hfad.mymovies.core.network.Transformable
import com.hfad.mymovies.core.utils.TransformUtils


fun <T, E : Transformable<T>> Collection<E>?.transform(): List<T> {
    return TransformUtils().transformCollection(this)
}