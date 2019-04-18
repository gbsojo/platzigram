package com.gbsojo.platzigram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gbsojo.platzigram.R;
import com.gbsojo.platzigram.model.Post;
import com.gbsojo.platzigram.view.PostActivity;
import com.squareup.picasso.Picasso;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Period;

import java.util.ArrayList;

import 	android.util.Log;

public class PostRecyclerViewAdapter extends RecyclerView.Adapter<PostRecyclerViewAdapter.PostViewHolder> {

    private ArrayList<Post> posts;
    private int resource;
    private Activity activity;

    public PostRecyclerViewAdapter(ArrayList<Post> posts, int resource, Activity activity) {
        this.posts = posts;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(resource, viewGroup, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int i) {
        Post post = posts.get(i);
        DateTime today = new DateTime();
        Period period = new Period(post.getDate(), today);
        int[] periodArr = period.getValues();
        String[] periodsArr = new String[]{"years", "months", "days", "hours"};
        String elapsedTxt = null;

        for (int pos = 0; pos < 4; pos++) {
            if (periodArr[pos] > 0) {
                elapsedTxt = Integer.toString(periodArr[pos]) + " " + periodsArr[pos];
                break;
            }
        }
        postViewHolder.usernameView.setText(post.getUsername());
        postViewHolder.likesView.setText(Integer.toString(post.getLikes()));
        postViewHolder.elapsedTimeView.setText(elapsedTxt);
        Picasso.with(activity).load(post.getPicture()).into(postViewHolder.pictureView);

        postViewHolder.pictureView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(activity, PostActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        private ImageView pictureView;
        private TextView usernameView;
        private TextView elapsedTimeView;
        private TextView likesView;

        public PostViewHolder (View view) {
            super(view);

            pictureView = itemView.findViewById(R.id.cardview_picture);
            usernameView = itemView.findViewById(R.id.cardview_username);
            elapsedTimeView = itemView.findViewById(R.id.elapsed_time);
            likesView = itemView.findViewById(R.id.cardview_likes_qty);
        }
    }
}
