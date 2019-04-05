package com.gbsojo.platzigram.adapter;

import android.app.Activity;
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

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Period;

import java.util.ArrayList;

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
        postViewHolder.usernameView.setText(post.getUsername());
        postViewHolder.likesView.setText(Integer.toString(post.getLikes()));
        postViewHolder.elapsedTimeView.setText(period.toString());
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
            likesView = itemView.findViewById(R.id.cardview_like);
        }
    }
}
