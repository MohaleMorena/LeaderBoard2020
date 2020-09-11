package com.example.leaderboard2020;

import com.google.gson.annotations.SerializedName;

public class LeaderBoardModel {
    @SerializedName("name")
    String name;
    @SerializedName("hours")
    String hours;
    @SerializedName("country")
    String country;

    @SerializedName("badgeUrl")
    String fullUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullUrl() {
        return fullUrl;
    }

}
