package com.vraman.moviereferee.apis.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieListModel {

    @SerializedName("page")
    private int page;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("results")
    private List<MovieDetailModel> movieList;

    public MovieListModel(int page, int totalResults, int totalPages, List<MovieDetailModel> movieList) {
        this.page = page;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
        this.movieList = movieList;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<MovieDetailModel> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<MovieDetailModel> movieList) {
        this.movieList = movieList;
    }

}
