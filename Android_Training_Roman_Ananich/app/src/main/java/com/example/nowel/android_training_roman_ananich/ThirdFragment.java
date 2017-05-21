package com.example.nowel.android_training_roman_ananich;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Nowel on 31.03.2017.
 */

public class ThirdFragment extends Fragment {
    ListAdapter2 adapter;
    ListView lv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_second,container,false);
        lv= (ListView) rootView.findViewById(R.id.list_View);
        adapter=new ListAdapter2(this.getActivity(),getDocumentaries());
        lv.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onCreateOptionsMenu (Menu menu, MenuInflater inflater){
        inflater.inflate(R.menu.search_frag, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView sv = new SearchView(((MainActivity) getActivity()).getSupportActionBar().getThemedContext());
        MenuItemCompat.setShowAsAction(item, MenuItemCompat.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
        MenuItemCompat.setActionView(item, sv);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                System.out.println("search query submit");

                adapter.filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                System.out.println("tap");
                adapter.getFilter().filter(newText);
                return false;
            }



        });
    }

    private ArrayList<Test> getDocumentaries() {
        ArrayList<Test> movies=new ArrayList<>();
        Test movie=new Test();
        movies.add(movie);
        Test movie1=new Test();
        movies.add(movie1);
        Test movie2=new Test();
        movies.add(movie2);
        Test movie3=new Test();
        movies.add(movie3);
        Test movie4=new Test();
        movies.add(movie4);

        return movies;
    }
    @Override
    public String toString() {
        return "Documentary";
    }

}
