package com.vraman.moviereferee.fragments;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.vraman.moviereferee.R;
import com.vraman.moviereferee.adapters.ListViewAdapter;
import com.vraman.moviereferee.adapters.MovieViewAdapter;
import com.vraman.moviereferee.apis.MovieDataServiceImpl;
import com.vraman.moviereferee.apis.callbacks.VolleyCallback;
import com.vraman.moviereferee.apis.models.MovieDetailModel;
import com.vraman.moviereferee.apis.models.MovieListModel;
import com.vraman.moviereferee.managers.ImageManager;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    private RecyclerView movieRecyclerView;
    private RecyclerView trendingRecyclerView;
    private RecyclerView listRecyclerView;
    private RecyclerView.LayoutManager movieLayoutManager;
    private RecyclerView.LayoutManager trendingLayoutManager;
    private RecyclerView.LayoutManager listLayoutManager;
    private MovieViewAdapter movieViewAdapter;
    private MovieViewAdapter trendingViewAdapter;
    private ListViewAdapter listViewAdapter;
    private ArrayList<MovieDetailModel> movieDetailModels = new ArrayList<>();

    private Context context;
    public MainFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(Context context) {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        movieLayoutManager =  new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        trendingLayoutManager =  new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        listLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        movieViewAdapter = new MovieViewAdapter(movieDetailModels, context);
        trendingViewAdapter = new MovieViewAdapter(movieDetailModels, context);
        List<String> itemList = new ArrayList<>();
        itemList.add("International");
        itemList.add("Bollywood");
        itemList.add("Tamil");
        itemList.add("Older");
        itemList.add("Other");
        listViewAdapter =new ListViewAdapter(itemList, context,R.layout.list_view_item);
        movieRecyclerView = view.findViewById(R.id.movieRecyclerView);
        movieRecyclerView.setLayoutManager(movieLayoutManager);
        movieRecyclerView.setAdapter(movieViewAdapter);

        trendingRecyclerView = view.findViewById(R.id.trendingRecyclerView);
        trendingRecyclerView.setLayoutManager(trendingLayoutManager);
        trendingRecyclerView.setAdapter(trendingViewAdapter);

        listRecyclerView = view.findViewById(R.id.listRecyclerView);
        listRecyclerView.setLayoutManager(listLayoutManager);
        listRecyclerView.setAdapter(listViewAdapter);

        movieDetailModels = (ArrayList<MovieDetailModel>) new MovieDataServiceImpl(getActivity()).getMovieList(new VolleyCallback() {
            @Override
            public Object onSuccess(String response) {
                MovieListModel movieListModel = new Gson().fromJson(response, MovieListModel.class);
                for(MovieDetailModel movieDetailModel : movieListModel.getMovieList())
                    Log.i("MainActivity", movieListModel.getMovieList().get(0).getTitle());
                movieViewAdapter.setMovieList(movieListModel.getMovieList());
                trendingViewAdapter.setMovieList(movieListModel.getMovieList());
                movieViewAdapter.notifyDataSetChanged();
                trendingViewAdapter.notifyDataSetChanged();
                return movieListModel.getMovieList();
            }
        });
        return view;
    }

}
