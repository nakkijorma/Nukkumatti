package com.example.juuso.nukkumatti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UniMaara extends AppCompatActivity implements View.OnClickListener {
    private String pvm; // pvm muotoa 22/05/2018
    private double tunnit; // tunnit pilkulla 7,5
    private Button buttonLaheta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uni_maara);

        buttonLaheta = findViewById(R.id.buttonLaheta);
        buttonLaheta.setOnClickListener(this);
    }
    @Override

    // Tämä kuuntelee Lähetä-nappia
    public void onClick(View view) {
        // TODO - Tähän tietojen tallennus listaan.
    }
}
