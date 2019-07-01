package com.practice.simpleretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.practice.simpleretrofit.RecyclerView.Adapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Adapter adapter;
    static ArrayList<MovieInfoModel> movieInfo;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fetchMovieInfo();

    }

    public void fetchMovieInfo() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<MovieInfoModel>> serviceCall = apiService.getMovieInfo();
        serviceCall.enqueue(new Callback<List<MovieInfoModel>>() {
            @Override
            public void onResponse(Call<List<MovieInfoModel>> call, Response<List<MovieInfoModel>> response) {
                List<MovieInfoModel> retrievedData = response.body();
                movieInfo = new ArrayList<>();

                for (int i = 0; i < retrievedData.size(); i++) {
                    movieInfo.add(new MovieInfoModel(retrievedData.get(i).getName(),
                            retrievedData.get(i).getRealname(),
                            retrievedData.get(i).getTeam(),
                            retrievedData.get(i).getFirstappearance(),
                            retrievedData.get(i).getCreatedby(),
                            retrievedData.get(i).getPublisher(),
                            retrievedData.get(i).getImageurl(),
                            retrievedData.get(i).getBio()));
                }

                createRecyclerView();
            }

            @Override
            public void onFailure(Call<List<MovieInfoModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    private void createRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view_movie);
        adapter = new Adapter(this, movieInfo);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
