package com.vraman.moviereferee.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vraman.moviereferee.MovieDetailActivity;
import com.vraman.moviereferee.R;

import java.util.List;

/**
 * Created by vraman on 1/20/18.
 */

public class MovieListViewAdapter  extends BaseListViewAdapter {

    private List<String> itemList;
    private Context context;
    private int resourceLayout;

    public MovieListViewAdapter(List<String> itemList, Context context, int resourceLayout) {
        super(context, resourceLayout);
        this.context = context;
        this.itemList = itemList;
        this.resourceLayout = resourceLayout;
    }

    @Override
    public MovieListViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resourceLayout, parent, false);
        MovieListViewAdapter.ViewHolder viewHolder = new MovieListViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseListViewAdapter.ViewHolder holder, int position) {
        ((MovieListViewAdapter.ViewHolder)holder).text.setText(itemList.get(position));
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends BaseListViewAdapter.ViewHolder implements View.OnClickListener {

        private TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, MovieDetailActivity.class);
            context.startActivity(intent);
        }
    }
}
