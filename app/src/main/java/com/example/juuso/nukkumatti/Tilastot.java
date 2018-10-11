package com.example.juuso.nukkumatti;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.List;

public class Tilastot extends AppCompatActivity {

    private UniTilastoViewModel uniTilastoViewModel;
    private double avgTunnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setContentView(R.layout.activity_tilastot);

        // RecyclerView recyclerView = findViewById(R.id.)
        // avgTunnit = uniTilastoViewModel.getAvgTunnit();
        TextView avgView = findViewById(R.id.textViev_avg);
        String avg = String.valueOf(avgTunnit);
        avgView.setText(avg);
    }
/*
    private double calculateAverage(List<Integer> marks) {
        Integer sum = 0;
        if(!marks.isEmpty()) {
            for (Integer mark : marks) {
                sum += mark;
            }
            return sum.doubleValue() / marks.size();
        }
        return sum;
    }*/
}
