package com.hfad.mymovies.core.adapter

import android.util.Log
import android.util.SparseArray
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BaseAdapter : RecyclerView.Adapter<BindableViewHolder>() {

    private var itemControllers = SparseArray<BindableItemController>()
    private var bindableItems = mutableListOf<BindableItem>()


    fun add(bindableItems: List<BindableItem>){
        this.bindableItems.addAll(bindableItems)
            Log.i("TAGG", "bindableItem ${bindableItems[0]}")

        bindableItems.forEach {
            itemControllers.put(it.itemController.viewType(), it.itemController)
        }

        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        Log.i("TAGG", "getItemViewType $position")
        return bindableItems[position].itemController.viewType()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindableViewHolder {
        Log.i("TAGG", "onCreateViewHolder")
        return itemControllers.get(viewType).createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: BindableViewHolder, position: Int) {
        Log.i("TAGG", "onBindViewHolder")
        val item = bindableItems[position]
        Log.i("TAGG", "onBindViewHolder bindableItem $item")
        item.itemController.bind(holder, item.data)
    }

    override fun getItemCount(): Int {
        Log.i("TAGG", "getItemCount")
        return bindableItems.size
    }
}