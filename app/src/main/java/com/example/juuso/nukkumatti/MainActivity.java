package com.example.juuso.nukkumatti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonSyote;
    private Button buttonHistoria;
    private Button buttonTilastot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSyote = findViewById(R.id.buttonSyote);
        buttonHistoria = findViewById(R.id.buttonHistoria);
        buttonTilastot = findViewById(R.id.buttonTilastot);
        buttonSyote.setOnClickListener(this);
        buttonHistoria.setOnClickListener(this);
        buttonTilastot.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonSyote:
                Intent intent1 = new Intent(this, UniMaara.class);
                startActivity(intent1);
                break;
            case R.id.buttonHistoria:
                Intent intent2 = new Intent(this, Historia.class);
                startActivity(intent2);
                break;
            case R.id.buttonTilastot:
                Intent intent3 = new Intent(this, Tilastot.class);
                startActivity(intent3);
                break;
            default:
                break;

    }


    // TODO - testi2

    }
}
