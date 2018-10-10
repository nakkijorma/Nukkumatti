package com.example.juuso.nukkumatti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Historia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia);

        ListView lv = findViewById(R.id.listview);
        Lista tulostus = new Lista();
        lv.setAdapter(new ArrayAdapter<Olio>(this, android.R.layout.simple_list_item_1, tulostus.getOliot()));



    }



}
