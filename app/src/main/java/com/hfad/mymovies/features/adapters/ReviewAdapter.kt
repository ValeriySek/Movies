package com.hfad.mymovies.features.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hfad.mymovies.features.adapters.ReviewAdapter.ReviewViewHolder
import com.hfad.mymovies.features.data.models.Review
import com.hfad.mymovies.databinding.ReviewItemBinding
import java.util.*

class ReviewAdapter : RecyclerView.Adapter<ReviewViewHolder>() {
    private var mReviews: List<Review> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ReviewItemBinding.inflate(inflater, parent, false)
        return ReviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val review = mReviews[position]
        holder.bind(review)
    }

    override fun getItemCount(): Int {
        return mReviews.size
    }

    fun setReviews(reviews: List<Review>) {
        mReviews = reviews
        notifyDataSetChanged()
    }

    inner class ReviewViewHolder(var mBinding: ReviewItemBinding) : RecyclerView.ViewHolder(mBinding.root) {
        fun bind(review: Review?) {
//            mBinding.setReview(review);
//            mBinding.executePendingBindings();
        }
    }
}