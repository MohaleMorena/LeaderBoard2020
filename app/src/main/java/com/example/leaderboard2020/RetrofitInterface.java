package com.example.leaderboard2020;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public class RetrofitInterface {
    @GET("/api/hours")
    Call < List < LeaderBoardModel > > getAllLeaders() {
        return null;
    }

}
