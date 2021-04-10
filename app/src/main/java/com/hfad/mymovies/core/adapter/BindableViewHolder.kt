package com.hfad.mymovies.core.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BindableViewHolder : RecyclerView.ViewHolder {

    constructor(parent: ViewGroup, @LayoutRes layoutRes: Int) : super(LayoutInflater.from(parent.context).inflate(layoutRes, parent, false))
    constructor(itemView: View) : super(itemView)

    abstract fun bind(data: Any)
}