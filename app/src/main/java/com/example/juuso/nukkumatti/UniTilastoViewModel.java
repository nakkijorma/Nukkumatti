package com.example.juuso.nukkumatti;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.juuso.nukkumatti.db.UniTilasto;

import java.util.List;

public class UniTilastoViewModel extends AndroidViewModel {
    private UniRepository repository;
    private LiveData<List<UniTilasto>> allUniTilastot;

    public UniTilastoViewModel(@NonNull Application application) {
        super(application);
        repository = new UniRepository(application);
        allUniTilastot = repository.getAllUniTilastot();
    }

    public void insert(UniTilasto uniTilasto) {
        repository.insert(uniTilasto);
    }

    public void update(UniTilasto uniTilasto) {
        repository.update(uniTilasto);

    }

    public void delete(UniTilasto uniTilasto) {
        repository.delete(uniTilasto);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public LiveData<List<UniTilasto>> getAllUniTilastot() {
        return allUniTilastot;
    }
}
