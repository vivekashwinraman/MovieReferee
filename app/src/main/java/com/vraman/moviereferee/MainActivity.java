package com.vraman.moviereferee;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.vraman.moviereferee.adapters.ListViewAdapter;
import com.vraman.moviereferee.adapters.MovieViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView movieRecyclerView;
    private RecyclerView trendingRecyclerView;
    private RecyclerView listRecyclerView;
    private RecyclerView.LayoutManager movieLayoutManager;
    private RecyclerView.LayoutManager trendingLayoutManager;
    private RecyclerView.LayoutManager listLayoutManager;
    private MovieViewAdapter movieViewAdapter;
    private MovieViewAdapter trendingViewAdapter;
    private ListViewAdapter listViewAdapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Toast.makeText(MainActivity.this, R.string.title_home, Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_account:
                    Toast.makeText(MainActivity.this, R.string.title_account, Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_notifications:
                    Toast.makeText(MainActivity.this, R.string.title_notifications, Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieLayoutManager =  new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        trendingLayoutManager =  new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        listLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        movieViewAdapter = new MovieViewAdapter(new ArrayList<String>());
        trendingViewAdapter = new MovieViewAdapter(new ArrayList<String>());
        listViewAdapter =new ListViewAdapter(new ArrayList<String>());

        movieRecyclerView = (RecyclerView) findViewById(R.id.movieRecyclerView);
        movieRecyclerView.setLayoutManager(movieLayoutManager);
        movieRecyclerView.setAdapter(movieViewAdapter);

        trendingRecyclerView = (RecyclerView) findViewById(R.id.trendingRecyclerView);
        trendingRecyclerView.setLayoutManager(trendingLayoutManager);
        trendingRecyclerView.setAdapter(trendingViewAdapter);

        listRecyclerView = (RecyclerView) findViewById(R.id.listRecyclerView);
        listRecyclerView.setLayoutManager(listLayoutManager);
        listRecyclerView.setAdapter(listViewAdapter);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
