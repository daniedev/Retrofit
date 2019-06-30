package com.practice.simpleretrofit.RecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.practice.simpleretrofit.MovieInfoModel;
import com.practice.simpleretrofit.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    Context context;
    ArrayList<MovieInfoModel> movieInfo;
    LayoutInflater inflater;
    View view;


    public Adapter(Context context, ArrayList<MovieInfoModel> movieInfoModel) {
        this.context = context;
        this.movieInfo = movieInfoModel;
        inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = inflater.inflate(R.layout.item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.movieName.setText(movieInfo.get(i).getName());
        viewHolder.movieBio.setText(movieInfo.get(i).getBio());
    }

    @Override
    public int getItemCount() {
        return movieInfo.size();
    }
}
