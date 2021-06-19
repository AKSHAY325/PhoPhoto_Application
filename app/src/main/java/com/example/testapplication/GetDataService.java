package com.example.testapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/photos")
    Call<List<PhotoModel>> getAllData();
}
