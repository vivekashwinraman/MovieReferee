package com.vraman.moviereferee.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.vraman.moviereferee.MovieDetailActivity;
import com.vraman.moviereferee.R;

import java.util.List;


/**
 * Created by vraman on 11/26/17.
 */

public class MovieViewAdapter extends RecyclerView.Adapter<MovieViewAdapter.ViewHolder> {

    private List<String> movieList;
    private Context context;

    public MovieViewAdapter(List<String> movieList, Context context) {
        this.movieList = movieList;
        this.movieList.add("Test");
        this.movieList.add("Test");
        this.movieList.add("Test");
        this.movieList.add("Test");
        this.movieList.add("Test");
        this.movieList.add("Test");
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_view_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.movieImage.setImageResource(R.mipmap.movie_image1);
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
            context.startActivity(intent);
        }
    }

}
