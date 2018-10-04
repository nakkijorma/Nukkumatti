package com.example.juuso.nukkumatti;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UniMaara extends AppCompatActivity implements View.OnClickListener {
    private String pvm; // pvm muotoa 22/05/2018
    private String pvmToast;
    private double tunnit; // tunnit pisteellä 7.5
    private Button buttonLaheta;
    private CalendarView calendarView;
    private Long date;
    private TextView naytaPVM;
    private Toast toastPVM;
    private Toast toastTallenna;
    private EditText unimaaraSyote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uni_maara);

        calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                pvm = dayOfMonth + "/" + (month + 1) + "/" + year; //kuukausi Tammikuu == 0
                date = calendarView.getDate(); // Antaa  nykyisen hetken millisek
                pvmToast = date.toString();
                naytaPVM.setText(pvmToast + ", " + pvm + tunnit); // TODO - pvmToast näyttää millisekunnit nykyisellä hetkellä
                toastPVM = Toast.makeText(getApplicationContext(),pvm,Toast.LENGTH_LONG);
                toastPVM.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.RIGHT, 0, 200);
                toastPVM.show();
            }
        });

        naytaPVM = findViewById(R.id.naytaPVM);
        buttonLaheta = findViewById(R.id.buttonLaheta);
        buttonLaheta.setOnClickListener(this);

        //tunnit = Double.parseDouble(String.valueOf(unimaaraSyote.getText())); // Tai .toString

    }
    // TODO - CalenderView-tiedon lukeminen ja muokkaus
    // TODO - TextView-tiedon lukeminen ja mahd. muokkaus

    // Tämä kuuntelee Lahetä-nappia
    @Override
    public void tallenna(View v) {
        unimaaraSyote = findViewById(R.id.unimaaraSyote);
        tunnit = Double.parseDouble(unimaaraSyote.getText().toString());

        Olio tallennus = new Olio(pvm, tunnit);
        Lista lista = new Lista();
        lista.luoLista();

        // TODO - Tähän tietojen tallennus listaan.
        /* Intent intent3 = new Intent(this, Historia.class);
        startActivity(intent3); */

        toastTallenna = Toast.makeText(getApplicationContext(), R.string.toast_tallenna, Toast.LENGTH_LONG);
        toastTallenna.setGravity(Gravity.BOTTOM, 0, 0);
        toastTallenna.show();
    }



    }

