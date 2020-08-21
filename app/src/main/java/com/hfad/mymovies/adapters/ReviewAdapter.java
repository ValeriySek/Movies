package com.hfad.mymovies.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.mymovies.R;
import com.hfad.mymovies.data.models.Review;
import com.hfad.mymovies.databinding.ReviewItemBinding;

import java.util.ArrayList;
import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {

    private List<Review> mReviews = new ArrayList<>();

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ReviewItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.review_item, parent, false);
        return new ReviewViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        Review review = mReviews.get(position);
        holder.bind(review);
    }


    @Override
    public int getItemCount() {
        return mReviews.size();
    }

    public void setReviews(List<Review> reviews) {
        mReviews = reviews;
        notifyDataSetChanged();
    }

    class ReviewViewHolder extends RecyclerView.ViewHolder{

        ReviewItemBinding mBinding;

        public ReviewViewHolder(@NonNull ReviewItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        void bind(Review review){
            mBinding.setReview(review);
            mBinding.executePendingBindings();
        }
    }
}
