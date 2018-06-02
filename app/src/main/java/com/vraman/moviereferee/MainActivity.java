package com.vraman.moviereferee;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.vraman.moviereferee.apis.MovieDataServiceImpl;
import com.vraman.moviereferee.apis.callbacks.VolleyCallback;
import com.vraman.moviereferee.apis.models.MovieDetailModel;
import com.vraman.moviereferee.apis.models.MovieListModel;
import com.vraman.moviereferee.fragments.AccountFragment;
import com.vraman.moviereferee.fragments.MainFragment;
import com.vraman.moviereferee.fragments.NotificationsFragment;

import java.util.List;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    private Context context = this;
    private int menuItemId = R.id.navigation_home;
    private static final String MENU_ITEM = "menuItemId";
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            return loadFragment(item.getItemId());
        }
    };

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(MENU_ITEM, menuItemId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState !=null) {
            menuItemId = savedInstanceState.getInt(MENU_ITEM);
        }
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(menuItemId);
    }

    private boolean loadFragment(int menuItemId) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        Fragment currentFragment = null;
        this.menuItemId = menuItemId;
        switch (menuItemId) {
            case R.id.navigation_home:
                currentFragment = MainFragment.newInstance(context);
                break;
            case R.id.navigation_notifications:
                currentFragment = new NotificationsFragment();
                break;
            case R.id.navigation_account:
                currentFragment = new AccountFragment();
                break;
        }
        if (currentFragment != null) {
            transaction.replace(R.id.content, currentFragment);
            transaction.commit();
            return true;
        }
        return false;
    }
}
