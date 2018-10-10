package com.example.juuso.nukkumatti;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.juuso.nukkumatti.db.AppDatabase;
import com.example.juuso.nukkumatti.db.UniTilasto;
import com.example.juuso.nukkumatti.db.UniTilastoDao;

import java.util.List;

public class UniRepository {
    private UniTilastoDao uniTilastoDao;
    private LiveData<List<UniTilasto>> allUniTilastot;
    private LiveData<List<UniTilasto>> allUniTunnit;
    private double avgTunnit;

    public UniRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        uniTilastoDao = database.uniTilastoDao();
        allUniTilastot = uniTilastoDao.getAll();
        allUniTunnit = uniTilastoDao.getTunnitListaan();
        avgTunnit = uniTilastoDao.getAverageOfTunnit();
    };


    // API that repository exposes outside
    public void insert(UniTilasto uniTilasto) {
        new InsertUniTilastoAsyncTask(uniTilastoDao).execute(uniTilasto);

    }

    public void update(UniTilasto uniTilasto) {
        new UpdateUniTilastoAsyncTask(uniTilastoDao).execute(uniTilasto);

    }

    public  void delete(UniTilasto uniTilasto) {
        new DeleteAllUniTilastoAsyncTask(uniTilastoDao).execute(uniTilasto);
    }

    public  void deleteAll() {
        new DeleteAllUniTilastoAsyncTask(uniTilastoDao).execute();
    }

    public LiveData<List<UniTilasto>> getAllUniTilastot() { return allUniTilastot; }

    public LiveData<List<UniTilasto>> getAllUniTunnit() { return  allUniTunnit; }

    public double getAvgTunnit() {
        return avgTunnit;
    }

    private static class InsertUniTilastoAsyncTask extends AsyncTask<UniTilasto, Void, Void> {
        private UniTilastoDao uniTilastoDao;
        private InsertUniTilastoAsyncTask(UniTilastoDao uniTilastoDao) {
            this.uniTilastoDao = uniTilastoDao;
        }

        @Override
        protected Void doInBackground(UniTilasto... uniTilastos) {
            uniTilastoDao.insert(uniTilastos[0]);
            return null;
        }
    }

    private static class UpdateUniTilastoAsyncTask extends AsyncTask<UniTilasto, Void, Void> {
        private UniTilastoDao uniTilastoDao;
        private UpdateUniTilastoAsyncTask (UniTilastoDao uniTilastoDao) {
            this.uniTilastoDao = uniTilastoDao;
        }

        @Override
        protected Void doInBackground(UniTilasto... uniTilastos) {
            uniTilastoDao.update(uniTilastos[0]);
            return null;
        }
    }

    private static class DeleteUniTilastoAsyncTask extends AsyncTask<UniTilasto, Void, Void> {
        private UniTilastoDao uniTilastoDao;
        private DeleteUniTilastoAsyncTask(UniTilastoDao uniTilastoDao) {
            this.uniTilastoDao = uniTilastoDao;
        }

        @Override
        protected Void doInBackground(UniTilasto... uniTilastos) {
            uniTilastoDao.delete(uniTilastos[0]);
            return null;
        }
    }

    private static class DeleteAllUniTilastoAsyncTask extends AsyncTask<UniTilasto, Void, Void> {
        private UniTilastoDao uniTilastoDao;
        private DeleteAllUniTilastoAsyncTask(UniTilastoDao uniTilastoDao) {
            this.uniTilastoDao = uniTilastoDao;
        }

        @Override
        protected Void doInBackground(UniTilasto... uniTilastos) {
            uniTilastoDao.deleteAll();
            return null;
        }
    }
}
