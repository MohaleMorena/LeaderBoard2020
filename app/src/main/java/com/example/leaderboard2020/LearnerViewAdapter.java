package com.example.leaderboard2020;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LearnerViewAdapter extends RecyclerView.Adapter< LearnerViewAdapter.RecyclerHolder> {
    List <LeaderBoardModel> dataList;
     private Context context;


    public LearnerViewAdapter(List<LeaderBoardModel> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    public static void setLayoutManager(LinearLayoutManager linearLayoutManager) {

    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_row_learner, viewGroup, false);
        return new RecyclerHolder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder recyclerHolder, int position) {
        recyclerHolder.textName.setText(dataList.get(position).name);
        recyclerHolder.textCountry.setText(dataList.get(position).country);
        recyclerHolder.textVariable.setText(dataList.get(position).hours);
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader (context));
        builder.build().load(dataList.get(position).getFullUrl()).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_foreground).into(recyclerHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setAdapter(LearnerViewAdapter learnerViewAdapter) {

    }

    public static class RecyclerHolder extends ViewHolder {
        TextView textName;
        TextView textCountry;
        TextView textVariable;
        ImageView imageView;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.name);
            textCountry = itemView.findViewById(R.id.tvcountry);
            textVariable = itemView.findViewById(R.id.tv_variable);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
