package com.gbsojo.platzigram.view.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gbsojo.platzigram.R;
import com.gbsojo.platzigram.adapter.PostRecyclerViewAdapter;
import com.gbsojo.platzigram.model.Post;

import org.joda.time.DateTime;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimelineFragment extends Fragment {


    public TimelineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_timeline, container, false);
        this.showToolbar(getResources().getString(R.string.title_timeline), false, view);
        RecyclerView postsRecycler = view.findViewById(R.id.post_recycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        PostRecyclerViewAdapter postRecyclerViewAdapter = new PostRecyclerViewAdapter(getPosts(), R.layout.cardview_picture, getActivity());

        postsRecycler.setLayoutManager(linearLayoutManager);
        postsRecycler.setAdapter(postRecyclerViewAdapter);

        return view;
    }

    @SuppressLint("RestrictedApi")
    public void showToolbar (String title, boolean showUpButton, View view) {
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(showUpButton);
    }

    public ArrayList<Post> getPosts() {
        ArrayList<Post> posts = new ArrayList<Post>();
        posts.add(new Post("https://www.kissottawa.com/wp-content/uploads/sites/9/2017/12/CADA153-1120_2017_000134-1013x576.jpg", "p!nk", new DateTime(2004, 12, 25, 0, 0, 0, 0), 128734));
        posts.add(new Post("https://images.radio.com/aiu-media/Pink%2520MTV.jpg", "p!nk", new DateTime(2004, 12, 25, 0, 0, 0, 0), 128734));
        posts.add(new Post("https://vignette.wikia.nocookie.net/pink/images/0/08/469567_10150920259436398_1987970376_o.jpg/revision/latest?cb=20141222000625", "p!nk", new DateTime(2004, 12, 25, 0, 0, 0, 0), 128734));
        posts.add(new Post("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTI2RHqQvk-jI9ykawDyr8WxYGEZz2cP3dfW5vQ-Q6uAgNr5obUMQ", "p!nk", new DateTime(2004, 12, 25, 0, 0, 0, 0), 128734));
        posts.add(new Post("https://www.breatheheavy.com/wp-content/uploads/2018/10/pink-beautiful-trauma-tour-europe-100k-tickets.jpg", "p!nk", new DateTime(2004, 12, 25, 0, 0, 0, 0), 128734));
        return posts;
    }

}
