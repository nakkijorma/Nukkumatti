package com.example.juuso.nukkumatti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class UniMaara extends AppCompatActivity {
    private String pvm; // pvm muotoa 22/05/2018
    private double tunnit; // tunnit pilkulla 7,5
    private Button buttonLaheta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uni_maara);
    }
}
