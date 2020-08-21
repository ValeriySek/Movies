package com.hfad.mymovies.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ExampleReview {

    @SerializedName("results")
    @Expose
    private List<Review> resultsReview = null;

    public List<Review> getReviews() {
        return resultsReview;
    }

    public void setResultsReview(List<Review> results) {
        this.resultsReview = results;
    }
}
