package com.hfad.mymovies.core.adapter

import android.util.Log
import android.view.ViewGroup
import kotlin.random.Random

abstract class BaseItemController{

    private var hash = 0

    /**
     * Bind base item to holder
     *
     * @param holder holder to retrieve item
     * @param item   item to bind
     */
    abstract fun bind(holder: BindableViewHolder, item: Any)

    fun viewType(): Int {
        return getTypeHashCode()
    }

    /**
     * Create holder inside parent
     *
     * @param parent parent which holder will attach to
     */
    abstract fun createViewHolder(parent: ViewGroup): BindableViewHolder

    private fun getTypeHashCode(): Int {

        hash = if(hash != 0) hash else Random.nextInt()
        Log.i("TAGG", "hash $hash")
        return hash
    }
}
