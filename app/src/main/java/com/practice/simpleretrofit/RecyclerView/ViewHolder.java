package com.practice.simpleretrofit.RecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.practice.simpleretrofit.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView movieName;
    TextView movieBio;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        this.movieName = itemView.findViewById(R.id.movie_name);
        this.movieBio = itemView.findViewById(R.id.movie_bio);
    }
}
