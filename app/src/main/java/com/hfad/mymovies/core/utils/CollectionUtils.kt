package com.hfad.mymovies.core.utils

import com.hfad.mymovies.core.network.Transformable

class CollectionUtils {

    interface Mapper<V, R> {
        fun map(value: V): R
    }

    fun <T, E : Transformable<T>> mapEmptyIfNull(collection: Collection<E>?): ArrayList<T> {
        return collection?.let { map(collection) } ?: ArrayList()
    }

    fun <T, E : Transformable<T>> map(collection: Collection<E>): ArrayList<T> {
        val result = ArrayList<T>(collection.size)
        collection.forEach {
            result.add(it.transform())
        }
        return result
    }
}