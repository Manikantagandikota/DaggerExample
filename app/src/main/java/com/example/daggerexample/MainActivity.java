package com.example.daggerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daggerexample.model.TodoBean;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView textViewTitle;
    private TextView textViewCompleted;
   private RecyclerView recyclerView;
    @Inject
    Retrofit retrofit;

    private TodoApi todoApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        textViewTitle = findViewById(R.id.todo_title);
        textViewCompleted = findViewById(R.id.todo_completed);

        ((BaseApplication) getApplication()).getNetworkComponent().inject(this);
        todoApi = retrofit.create(TodoApi.class);
       /* todoApi.getTodos(1).enqueue(new Callback<TodoBean>() {
            @Override
            public void onResponse(Call<TodoBean> call, Response<TodoBean> response) {
                Log.d(TAG, "onResponse: "+response.body().getTitle());
                textViewTitle.setText(response.body().getTitle());
                textViewCompleted.setText(String.valueOf(response.body().isCompleted()));
            }

            @Override
            public void onFailure(Call<TodoBean> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });*/

        todoApi.getsuperHeroes().enqueue(new Callback<List<ResultsModel> >() {
            @Override
            public void onResponse(Call<List<ResultsModel>> call, Response<List<ResultsModel>> response) {
                List<ResultsModel> heroList = response.body();
             //   Log.d(TAG, "onResponse: "+response.body().getTitle());
             //   textViewTitle.setText(response.body().getTitle());
             //   textViewCompleted.setText(String.valueOf(response.body().isCompleted()));
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
                ListAdapter cardsadapter = new ListAdapter(MainActivity.this, heroList);
                recyclerView.setAdapter(cardsadapter);
            }

            @Override
            public void onFailure(Call<List<ResultsModel>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });

    }


}