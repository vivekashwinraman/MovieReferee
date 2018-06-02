package com.vraman.moviereferee.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.vraman.moviereferee.MovieDetailActivity;
import com.vraman.moviereferee.R;
import com.vraman.moviereferee.apis.models.MovieDetailModel;
import com.vraman.moviereferee.managers.ImageManager;

import java.util.List;


/**
 * Created by vraman on 11/26/17.
 */

public class MovieViewAdapter extends RecyclerView.Adapter<MovieViewAdapter.ViewHolder> {

    private static final String IMAGE_URL  = "http://image.tmdb.org/t/p/w185/";
    private List<MovieDetailModel> movieList;
    private Context context;
    protected ImageManager imageManager;

    public MovieViewAdapter(List<MovieDetailModel> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
        imageManager = new ImageManager(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_view_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String url =  IMAGE_URL + movieList.get(position).getPosterPath();
        Picasso.get()
                .load(url)
                .placeholder(R.mipmap.movie_image1)
                .error(R.mipmap.movie_image1)
                .into( holder.movieImage);

       /* final Bitmap bitmap = imageManager.getBitmapFromCache(url);
        if (bitmap == null) {
            imageManager.loadImage(holder.movieImage, url);
        } else {
            holder.movieImage.setImageBitmap(bitmap);
        }*/
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView movieImage;

        public ViewHolder(View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.movieImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, MovieDetailActivity.class);
            Bundle bundle = new Bundle();
            MovieDetailModel movieDetailModel = movieList.get(getAdapterPosition());
            bundle.putParcelable("movie", movieDetailModel);
            intent.putExtras(bundle);
            context.startActivity(intent);
        }
    }

    public  void setMovieList(List<MovieDetailModel> movieList){
        this.movieList = movieList;
    }

}
