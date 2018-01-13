package com.vraman.moviereferee.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vraman.moviereferee.MovieDetailActivity;
import com.vraman.moviereferee.R;

import java.util.List;

/**
 * Created by vraman on 12/9/17.
 */

public class ListViewAdapter  extends RecyclerView.Adapter<ListViewAdapter.ViewHolder> {

    private List<String> itemList;
    private Context context;

    public ListViewAdapter(List<String> itemList, Context context) {
        this.context = context;
        this.itemList = itemList;
        this.itemList.add("International");
        this.itemList.add("Bollywood");
        this.itemList.add("Tamil");
        this.itemList.add("Older");
        this.itemList.add("Other");
    }

    @Override
    public ListViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_item, parent, false);
        ListViewAdapter.ViewHolder viewHolder = new ListViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListViewAdapter.ViewHolder holder, int position) {

        holder.text.setText(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, MovieDetailActivity.class);
            context.startActivity(intent);
        }
    }
}
