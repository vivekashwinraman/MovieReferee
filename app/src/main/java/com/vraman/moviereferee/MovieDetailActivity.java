package com.vraman.moviereferee;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vraman.moviereferee.apis.models.MovieDetailModel;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView movieImage;
    private TextView title;
    private TextView overview;
    private TextView releaseDate;
    private TextView voteCount;
    private TextView voteAverage;
    private MovieDetailModel movieDetailModel;
    private static final String IMAGE_URL  = "http://image.tmdb.org/t/p/w185/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        movieDetailModel =  getIntent().getParcelableExtra("movie");
        movieImage = findViewById(R.id.moviePoster);
        title = findViewById(R.id.movieTitle) ;
        overview = findViewById(R.id.movieOverview);
        releaseDate = findViewById(R.id.releaseDate);
        voteCount =  findViewById(R.id.voteCount);
        voteAverage = findViewById(R.id.voteAverage);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(movieDetailModel.getTitle());
        title.setText(movieDetailModel.getTitle());
        overview.setText(movieDetailModel.getOverview());
        releaseDate.setText("Release Date :" + movieDetailModel.getReleaseDate());
        voteCount.setText("Vote Count : " + movieDetailModel.getVoteCount());
        voteAverage.setText("Vote Average :" + movieDetailModel.getVoteAverage());
        String url =  IMAGE_URL + movieDetailModel.getPosterPath();
        Picasso.get()
                .load(url)
                .placeholder(R.mipmap.movie_image1)
                .error(R.mipmap.movie_image1)
                .into(movieImage);
    }

}
