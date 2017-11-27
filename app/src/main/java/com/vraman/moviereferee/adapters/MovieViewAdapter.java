package com.vraman.moviereferee.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.vraman.moviereferee.R;

import java.util.List;


/**
 * Created by vraman on 11/26/17.
 */

public class MovieViewAdapter extends RecyclerView.Adapter<MovieViewAdapter.ViewHolder> {

    private List<String> movieList;

    public MovieViewAdapter(List<String> movieList){
        this.movieList = movieList;
        this.movieList.add("Test");
        this.movieList.add("Test");
        this.movieList.add("Test");
        this.movieList.add("Test");
        this.movieList.add("Test");
        this.movieList.add("Test");
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_view_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView movieImage;
        public ViewHolder(View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.movieImage);
        }

    }
}
