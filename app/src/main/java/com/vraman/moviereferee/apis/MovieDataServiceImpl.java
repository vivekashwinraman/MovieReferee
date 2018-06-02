package com.vraman.moviereferee.apis;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.vraman.moviereferee.apis.callbacks.VolleyCallback;
import com.vraman.moviereferee.apis.models.MovieListModel;

/**
 * Created by vraman on 3/1/18.
 */

public class MovieDataServiceImpl implements  MovieDataService{

    private static final String GET_URL = "https://api.themoviedb.org/3/discover/movie?api_key=45aa5f1bd2a9ec25008e091135c51407&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1";
    private static final String IMAGE_URL  = "http://image.tmdb.org/t/p/w185//87hTDiay2N2qWyX4Ds7ybXi9h8I.jpg";
    private Context context;

    public MovieDataServiceImpl(Context context){
        this.context = context;
    }

    @Override
    public Object getMovieList(final VolleyCallback callback) {
        RequestQueue queue = Volley.newRequestQueue(this.context);

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, GET_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        String val = response;
                        callback.onSuccess(val);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String val = error.getLocalizedMessage();
            }
        });

    // Add the request to the RequestQueue.
        queue.add(stringRequest);
        return null;
    }
}
