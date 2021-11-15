package com.example.daggerexample;


import com.example.daggerexample.model.TodoBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TodoApi {
    @GET("/todos/{id}")
    Call<TodoBean> getTodos(
            @Path("id") int id);

    @GET("marvel")
    Call<List<ResultsModel>> getsuperHeroes();

}