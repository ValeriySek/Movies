package com.hfad.mymovies.core.utils.extentoins

import com.hfad.mymovies.core.utils.CollectionUtils
import java.util.*

object Vdsd {
    fun <T, V> mapEmptyIfNull(collection: Collection<T>?, mapper: CollectionUtils.Mapper<T, V>): List<V> {
        return collection?.let { map(it, mapper) } ?: ArrayList()
    }

    /**
     * Трансформирует коллекцию
     */
    fun <T, V> map(collection: Collection<T>, mapper: CollectionUtils.Mapper<T, V>): List<V> {
        val result = ArrayList<V>(collection.size)
        for (origin in collection) {
            result.add(mapper.map(origin))
        }
        return result
    }
}