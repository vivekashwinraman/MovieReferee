package com.vraman.moviereferee.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by vraman on 1/20/18.
 */

public abstract class BaseListViewAdapter  extends RecyclerView.Adapter<BaseListViewAdapter.ViewHolder> {

    protected Context context;
    protected int resourceLayout;

    public BaseListViewAdapter(Context context, int resourceLayout) {
        this.context = context;
        this.resourceLayout = resourceLayout;
    }

    public abstract class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
