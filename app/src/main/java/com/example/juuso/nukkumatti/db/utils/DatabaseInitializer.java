/*
package com.example.juuso.nukkumatti.db.utils;

import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.juuso.nukkumatti.db.AppDatabase;
import com.example.juuso.nukkumatti.db.UniTilasto;

import java.util.List;

public class DatabaseInitializer {

    private static final String TAG = DatabaseInitializer.class.getName();

    public static void populateAsync(final AppDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    private static UniTilasto addUniTilasto(final AppDatabase db, UniTilasto unitilasto) {
        db.uniTilastoModel().insertAll(unitilasto);
        return unitilasto;
    }

    private static void populateWithTestData(AppDatabase db) {

        UniTilasto uniTilasto = new UniTilasto();
        uniTilasto.setPvm("13.12.1989");
        uniTilasto.setTunnit(24);
        uniTilasto.setFiilis("Hilpeä");
        addUniTilasto(db, uniTilasto);

        LiveData<List<UniTilasto>> uniTilastoLista = db.uniTilastoModel().getAll();
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + uniTilastoLista.size());
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {mDb = db}

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }
    }
}
*/