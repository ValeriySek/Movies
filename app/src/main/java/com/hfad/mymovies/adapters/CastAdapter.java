package com.hfad.mymovies.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.mymovies.R;
import com.hfad.mymovies.data.models.Actors;
import com.hfad.mymovies.databinding.ActorItemBinding;

import java.util.ArrayList;
import java.util.List;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastHolder> {

    private List<Actors> mActorsList = new ArrayList<>();

    public void setActorsList(List<Actors> actorsList) {
        mActorsList = actorsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CastHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ActorItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.actor_item, parent, false);
        return new CastHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CastHolder holder, int position) {
        holder.bind(mActorsList.get(position));
    }

    @Override
    public int getItemCount() {
        return mActorsList.size();
    }

    static class CastHolder extends RecyclerView.ViewHolder{

        ActorItemBinding mBinding;

        public CastHolder(ActorItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(Actors actors){
            mBinding.setActor(actors);
            mBinding.executePendingBindings();
        }
    }
}
