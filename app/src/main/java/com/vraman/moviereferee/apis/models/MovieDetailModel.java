package com.vraman.moviereferee.apis.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class MovieDetailModel implements Parcelable {

    private int id;
    private String title;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("original_language")
    private String originalLanguage;
    private double popularity;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("backdrop_path")
    private String backdropPath;
    private String overview;
    @SerializedName("release_date")
    private String releaseDate;
    private boolean adult;
    @SerializedName("vote_average")
    private double voteAverage;
    @SerializedName("vote_count")
    private int voteCount;
    private boolean video;

    public MovieDetailModel(){

    }

    public MovieDetailModel(int id, String title, String originalTitle, String originalLanguage, double popularity, String posterPath, String backdropPath, String overview, String releaseDate, boolean adult, double voteAverage, int voteCount, boolean video) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.originalLanguage = originalLanguage;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.adult = adult;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.video = video;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(originalTitle);
        parcel.writeString(originalLanguage);
        parcel.writeDouble(popularity);
        parcel.writeString(posterPath);
        parcel.writeString(backdropPath);
        parcel.writeString(overview);
        parcel.writeString(releaseDate);
        parcel.writeByte((byte ) (adult == true? 1:0));
        parcel.writeDouble(voteAverage);
        parcel.writeInt(voteCount);
        parcel.writeByte((byte ) (video == true? 1:0));
    }

    public static final Parcelable.Creator<MovieDetailModel> CREATOR = new Creator<MovieDetailModel>() {
        public MovieDetailModel createFromParcel(Parcel source) {
            MovieDetailModel movieDetailModel = new MovieDetailModel();
            movieDetailModel.id = source.readInt();
            movieDetailModel.title = source.readString();
            movieDetailModel.originalTitle = source.readString();
            movieDetailModel.originalLanguage = source.readString();
            movieDetailModel.popularity = source.readDouble();
            movieDetailModel.posterPath = source.readString();
            movieDetailModel.backdropPath = source.readString();
            movieDetailModel.overview = source.readString();
            movieDetailModel.releaseDate = source.readString();
            movieDetailModel.adult = source.readByte() !=0;
            movieDetailModel.voteAverage = source.readInt();
            movieDetailModel.voteCount = source.readInt();
            movieDetailModel.video = source.readByte() !=0;

            return movieDetailModel;
        }

        public MovieDetailModel[] newArray(int size) {
            return new MovieDetailModel[size];
        }
    };
}
