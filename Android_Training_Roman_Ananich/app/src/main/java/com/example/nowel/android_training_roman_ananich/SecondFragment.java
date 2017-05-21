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
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Nowel on 31.03.2017.
 */

public class SecondFragment extends Fragment {
    ListAdapter adapter;
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
        adapter=new ListAdapter(this.getActivity(),getDocumentaries());
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

    private ArrayList<Lesson> getDocumentaries() {
        ArrayList<Lesson> movies=new ArrayList<>();
        Lesson movie=new Lesson();
        movies.add(movie);
        Lesson movie1=new Lesson("Video","Testsad","QaqBRX8aCQA");
        movies.add(movie1);
        Lesson movie2=new Lesson("Video","Teest2sad","R4hNmWvFcxo");
        movies.add(movie2);
        Lesson movie3=new Lesson("Text","Teaest3sad","R4hNmWvFcxo");
        movies.add(movie3);
        Lesson movie4=new Lesson("Text","T4eest4sad","04-05 20:51:35.611 27267-27267/com.example.nowel.parkstmp E/Trace: error opening trace file: No such file or directory (2)\n" +
                "04-05 20:51:42.159 27267-27267/com.example.nowel.parkstmp E/PhonePolicy: Could not preload class for phone policy: com.android.internal.policy.impl.PhoneWindow$ContextMenuCallback\n" +
                "04-05 20:51:43.225 27267-27267/com.example.nowel.parkstmp E/dalvikvm: Could not find class 'android.graphics.drawable.RippleDrawable', referenced from method android.support.v7.widget.AppCompatImageHelper.hasOverlappingRendering\n" +
                "04-05 20:51:55.292 27267-27505/com.example.nowel.parkstmp E/NativeCrypto: ssl=0x5c0ee4d8 cert_verify_callback x509_store_ctx=0x5eb86ae8 arg=0x0\n" +
                "04-05 20:51:55.293 27267-27505/com.example.nowel.parkstmp E/NativeCrypto: ssl=0x5c0ee4d8 cert_verify_callback calling verifyCertificateChain authMethod=ECDHE_RSA\n" +
                "04-05 20:51:56.560 27267-27472/com.example.nowel.parkstmp E/AndroidRuntime: FATAL EXCEPTION: GLThread 2820\n" +
                "                                                            ");
        movies.add(movie4);

        return movies;
    }
    @Override
    public String toString() {
        return "Documentary";
    }

}
