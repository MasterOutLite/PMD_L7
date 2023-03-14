package com.example.task3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceHolderApi {
    @GET("bank/currency")
    public Call<List<Currency>> getData();
}
