package com.vraman.moviereferee.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vraman.moviereferee.R;
import com.vraman.moviereferee.adapters.ListViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * interface.
 */
public class NotificationsFragment extends Fragment {

    private LinearLayoutManager notificationLayoutManager;
    private ListViewAdapter listViewAdapter;
    private RecyclerView listRecyclerView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NotificationsFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static NotificationsFragment newInstance(int columnCount) {
        NotificationsFragment fragment = new NotificationsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        notificationLayoutManager =  new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        List<String> itemList = new ArrayList<>();
        itemList.add("Notification 1");
        itemList.add("Notification 2");
        itemList.add("Notification 3");
        listViewAdapter =new ListViewAdapter(itemList, getActivity(), R.layout.fragment_item);
        listRecyclerView = view.findViewById(R.id.notificationList);
        listRecyclerView.setLayoutManager(notificationLayoutManager);
        listRecyclerView.setAdapter(listViewAdapter);
        return view;
    }

}
