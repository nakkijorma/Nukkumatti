package com.example.juuso.nukkumatti;

import android.app.Application;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.juuso.nukkumatti.db.UniTilasto;

public class UniMaara extends AppCompatActivity {

    private String pvm;
    private String tunnitString;
    private String fiilis;
    private Button tallennaPainike;
    private EditText nukututTunnit, kerroFiilis;
    private TextView valittuPvm;
    private CalendarView kalenteri;
    private UniTilastoViewModel uniTilastoViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uni_maara);
        valittuPvm =findViewById(R.id.naytaPVM);
        nukututTunnit = findViewById(R.id.unimaaraSyote);
        tallennaPainike = findViewById(R.id.buttonLaheta);
        kerroFiilis = findViewById(R.id.fiilisSyote);
        kalenteri = findViewById(R.id.calendarView);

        uniTilastoViewModel = ViewModelProviders.of(this).get(UniTilastoViewModel.class);

        kalenteri.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView kalenteri, int year, int month, int dayOfMonth) {
                pvm = dayOfMonth + "/" + (month + 1) + "/" + year;
                valittuPvm.setText(pvm);


            }
        });

        tallennaPainike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pvm = valittuPvm.getText().toString();
                tunnitString = nukututTunnit.getText().toString();
                double tunnit = Double.parseDouble(tunnitString);
                fiilis = kerroFiilis.getText().toString();

                if (pvm.trim().isEmpty() || tunnitString.length() <1 || fiilis.trim().isEmpty() ) {
                    toastMessage(R.string.toast_tyhjatKentat);
                    return;
                }

                UniTilasto uniTilasto = new UniTilasto(pvm, tunnit, fiilis);
                uniTilastoViewModel.insert(uniTilasto);

                valittuPvm.setText("");
                nukututTunnit.setText("");
                kerroFiilis.setText("");

                toastMessage(R.string.toast_tallenna);
            }
        });

    }
/*
    private void tallennaMerkinta() {
        String pvm = valittuPvm.getText().toString();
        String tunnitString = nukututTunnit.getText().toString();
        double tunnit = Double.parseDouble(tunnitString);
        String fiilis = kerroFiilis.getText().toString();

        if (pvm.trim().isEmpty() || tunnitString.trim().isEmpty()) {
            toastMessage("Muistithan klikata kalenterista päivämäärän ja täyttää kaikki kentät";
        }
    }
*/
    private void toastMessage(int resID){
        String message = getString(resID);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}










/*

package com.example.juuso.nukkumatti;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UniMaara extends AppCompatActivity {
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
    public ArrayList<Olio> lista;
    public ArrayAdapter<Olio> tulostus;
    public ListView naytto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uni_maara);

        lista = new ArrayList<Olio>();
        naytto.setAdapter(new ArrayAdapter<Olio>(UniMaara.this, android.R.layout.simple_list_item_1, lista));

        calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                pvm = dayOfMonth + "/" + (month + 1) + "/" + year; //kuukausi Tammikuu == 0
                date = calendarView.getDate(); // Antaa  nykyisen hetken millisek
                pvmToast = date.toString();
                naytaPVM.setText(pvmToast + ", " + pvm + tunnit); // TODO - pvmToast näyttää millisekunnit nykyisellä hetkellä
                toastPVM = Toast.makeText(getApplicationContext(),pvm,Toast.LENGTH_LONG);
                toastPVM.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.END, 0, 200);
                toastPVM.show();
            }
        });

        naytaPVM = findViewById(R.id.naytaPVM);
        unimaaraSyote = findViewById(R.id.unimaaraSyote);
        buttonLaheta = findViewById(R.id.buttonLaheta);
        buttonLaheta.setOnClickListener(clickListener);
        naytto = findViewById(R.id.naytto);



         if (unimaaraSyote.getText() != null) {
            tunnit = Double.parseDouble(unimaaraSyote.getText().toString());


        //tunnit = Double.parseDouble(String.valueOf(unimaaraSyote.getText())); // Tai .toString

    // TODO - CalenderView-tiedon lukeminen ja muokkaus
    // TODO - TextView-tiedon lukeminen ja mahd. muokkaus


    // Tämä kuuntelee Lahetä-nappia
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (unimaaraSyote.getText() != null) {
                tunnit = Double.parseDouble(unimaaraSyote.getText().toString());
            }
            // Lista lista = new Lista();
            lista.add(new Olio(pvm, tunnit));
            lista.add(new Olio("3/11/3018", 7.2));

            tulostus.notifyDataSetChanged();

            // TODO - Tähän tietojen tallennus listaan.
        /* Intent intent3 = new Intent(this, Historia.class);
        startActivity(intent3);

            toastTallenna = Toast.makeText(getApplicationContext(), R.string.toast_tallenna, Toast.LENGTH_LONG);
            toastTallenna.setGravity(Gravity.BOTTOM, 0, 0);
            toastTallenna.show();
        }
    };
    }

*/
