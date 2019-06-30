package com.practice.simpleretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiService {

    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<MovieInfoModel>> getMovieInfo();
}
