package com.example.juuso.nukkumatti.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {UniTilasto.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract UniTilastoDao uniTilastoDao();

    // synchronized, jottei tule toista instanssia, kun useammat threadit käytä Singleltonia samaan aikaan
    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "unitilasto_database")
                            // If version number is increased this tells how to migrate
                            .fallbackToDestructiveMigration()
                            .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    // To populate table oncreate
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {

        // Tässä listalle lisätään tavaraa vain onCreaten kohdalla
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private UniTilastoDao uniTilastoDao;

        private PopulateDbAsyncTask(AppDatabase db) {
            uniTilastoDao = db.uniTilastoDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            uniTilastoDao.insert(new UniTilasto("13/12/1989", 24, "Odottava tunnelma"));
            uniTilastoDao.insert(new UniTilasto("1/1/2017", 1.2, "Kuolemanväsynyt"));
            uniTilastoDao.insert(new UniTilasto("29/9/2018", 5.7, "Väsynyt"));
            uniTilastoDao.insert(new UniTilasto("11/10/2018", 9.25, "Virkeä"));
            uniTilastoDao.insert(new UniTilasto("14/12/2989", 8.9, "Hyvä"));
            uniTilastoDao.insert(new UniTilasto("5/2/2018", 9.2, "Rentoutunut"));
            return null;
        }
    }

    public static void destroyInstance() { instance = null; }
}
