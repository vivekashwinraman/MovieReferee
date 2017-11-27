package com.vraman.moviereferee;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.vraman.moviereferee.adapters.MovieViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView movieRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MovieViewAdapter movieViewAdapter;

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
        layoutManager =  new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        movieViewAdapter = new MovieViewAdapter(new ArrayList<String>());

        movieRecyclerView = (RecyclerView) findViewById(R.id.movieRecyclerView);
        movieRecyclerView.setLayoutManager(layoutManager);
        movieRecyclerView.setAdapter(movieViewAdapter);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
