package com.hfad.mymovies.core.adapter

import android.util.Log

abstract class BindableItemController
 : BaseItemController()
{
    override fun bind(holder: BindableViewHolder, item: Any) {
        Log.i("TAGG", "$holder  $item")
        holder.bind(item)
    }
}