package com.practice.simpleretrofit.RecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.practice.simpleretrofit.MovieInfoModel;
import com.practice.simpleretrofit.R;

import java.util.ArrayList;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView movieName;
    TextView movieBio;
    ImageView movieImage;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        this.movieName = itemView.findViewById(R.id.movie_name);
        this.movieBio = itemView.findViewById(R.id.movie_bio);
        this.movieImage = itemView.findViewById(R.id.movie_image);
    }
}
