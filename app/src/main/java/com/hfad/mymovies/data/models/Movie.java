package com.hfad.mymovies.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie extends MovieDiscover {

    @SerializedName("belongs_to_collection")
    @Expose
    private Object belongsToCollection;
    @SerializedName("budget")
    @Expose
    private int budget;
    @SerializedName("genres")
    @Expose
    private List<Genre> genres = null;
    @SerializedName("homepage")
    @Expose
    private String homepage;
    @SerializedName("imdb_id")
    @Expose
    private String imdbId;
//    @SerializedName("production_companies")
//    @Expose
//    private List<ProductionCompany> productionCompanies = null;
//    @SerializedName("production_countries")
//    @Expose
//    private List<ProductionCountry> productionCountries = null;
    @SerializedName("revenue")
    @Expose
    private int revenue;
    @SerializedName("runtime")
    @Expose
    private int runtime;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("tagline")
    @Expose
    private String tagline;

    public Object getBelongsToCollection() {
        return belongsToCollection;
    }

    public void setBelongsToCollection(Object belongsToCollection) {
        this.belongsToCollection = belongsToCollection;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

//    public List<ProductionCompany> getProductionCompanies() {
//        return productionCompanies;
//    }
//
//    public void setProductionCompanies(List<ProductionCompany> productionCompanies) {
//        this.productionCompanies = productionCompanies;
//    }
//
//    public List<ProductionCountry> getProductionCountries() {
//        return productionCountries;
//    }
//
//    public void setProductionCountries(List<ProductionCountry> productionCountries) {
//        this.productionCountries = productionCountries;
//    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }


    public Movie(double popularity, int voteCount, boolean video, String posterPath, int id, boolean adult, String backdropPath, String originalLanguage, String originalTitle, List<Integer> genreIds, String title, double voteAverage, String overview, String releaseDate) {
        super(popularity, voteCount, video, posterPath, id, adult, backdropPath, originalLanguage, originalTitle, genreIds, title, voteAverage, overview, releaseDate);
    }
}
