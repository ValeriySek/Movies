package com.hfad.mymovies.core.utils

import com.hfad.mymovies.core.network.Transformable

class TransformUtils {

    fun <T, E : Transformable<T>> transformCollection(collection: Collection<E>?): List<T> {
        return CollectionUtils().mapEmptyIfNull(collection)
    }
}