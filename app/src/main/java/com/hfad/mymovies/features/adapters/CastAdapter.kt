package com.hfad.mymovies.features.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hfad.mymovies.features.adapters.CastAdapter.CastHolder
import com.hfad.mymovies.features.data.models.Actors
import com.hfad.mymovies.databinding.ActorItemBinding
import java.util.*

class CastAdapter : RecyclerView.Adapter<CastHolder>() {
    private var mActorsList: List<Actors> = ArrayList()
    fun setActorsList(actorsList: List<Actors>) {
        mActorsList = actorsList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ActorItemBinding.inflate(inflater, parent, false)
        return CastHolder(binding)
    }

    override fun onBindViewHolder(holder: CastHolder, position: Int) {
        holder.bind(mActorsList[position])
    }

    override fun getItemCount(): Int {
        return mActorsList.size
    }

    class CastHolder(var mBinding: ActorItemBinding) : RecyclerView.ViewHolder(mBinding.root) {
        fun bind(actors: Actors?) {
//            mBinding.setActor(actors);
//            mBinding.executePendingBindings();
        }
    }
}