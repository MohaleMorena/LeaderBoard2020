package com.example.leaderboard2020;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView LearnerViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        LearnerViewAdapter = findViewById(R.id.decelerateAndComplete);
        com.example.leaderboard2020.LearnerViewAdapter.setLayoutManager(new LinearLayoutManager (MainActivity.this));
        RetrofitInterface retrofitInterface = RetrofitInstance.getRetrofitInstance().create(RetrofitInterface.class);
        Call <List<LeaderBoardModel>> listCall = retrofitInterface.getAllLeaders();
        listCall.enqueue(new Callback <List<LeaderBoardModel>> () {
            @Override
            public void onResponse(Call<List<LeaderBoardModel>> call, Response <List<LeaderBoardModel>> response) {
                parseData(response.body());

            }

            @Override
            public void onFailure(Call<List<LeaderBoardModel>> call, Throwable t) {

            }
        });
    }

    private void parseData(List <LeaderBoardModel> body) {
        LearnerViewAdapter learnerViewAdapter = new LearnerViewAdapter(body, getApplicationContext());
        learnerViewAdapter.setAdapter(learnerViewAdapter);
    }

    public void gotoTabs(View view) {
        Intent myIntent = new Intent (this, TabbedActivity.class);
        startActivity(myIntent);

    }
}