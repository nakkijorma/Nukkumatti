package com.example.juuso.nukkumatti;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.juuso.nukkumatti.db.UniTilasto;

import java.util.List;

public class HistoriaRoom extends AppCompatActivity {
    private UniTilastoViewModel uniTilastoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_historia_room);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final UniTilastoAdapter adapter = new UniTilastoAdapter();
        recyclerView.setAdapter(adapter);

        // Get ViewModel Instance, this ViewModel is destroyed when Activity is finished
        uniTilastoViewModel = ViewModelProviders.of(this).get(UniTilastoViewModel.class);

        // onChanged is triggered when data in Livedata-object changes
        uniTilastoViewModel.getAllUniTilastot().observe(this, new Observer<List<UniTilasto>>() {
            @Override
            public void onChanged(@Nullable List<UniTilasto> uniTilastos) {
                adapter.setUniTilastos(uniTilastos);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_historia_room, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.lataa_esim_lista:
                lataaEsimLista();
                toastMessage(R.string.toast_esim_lista_ladattu);
                return true;
            case R.id.tyhjenna_historia:
                uniTilastoViewModel.deleteAll();
                toastMessage(R.string.toast_historia_tyhjennetty);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void lataaEsimLista() {
        uniTilastoViewModel.insert(new UniTilasto("13/12/1989", 24, "Odottava tunnelma"));
        uniTilastoViewModel.insert(new UniTilasto("1/1/2017", 1.2, "Kuolemanväsynyt"));
        uniTilastoViewModel.insert(new UniTilasto("29/9/2018", 5.7, "Väsynyt"));
        uniTilastoViewModel.insert(new UniTilasto("11/10/2018", 9.25, "Virkeä"));
        uniTilastoViewModel.insert(new UniTilasto("14/12/2989", 8.9, "Hyvä"));
        uniTilastoViewModel.insert(new UniTilasto("5/2/2018", 9.2, "Rentoutunut"));
    }

    private void toastMessage(int resID){
        String message = getString(resID);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
