package com.example.juuso.nukkumatti.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

import java.util.List;

@Dao
public interface UniTilastoDao {
    @Query("select * from unitilasto_table order by uid desc") // TODO tämä lajittelee, mutta uid on huono tapa
    LiveData<List<UniTilasto>> getAll();

    @Insert(onConflict = REPLACE)
    void insertAll(UniTilasto... uniTilasto);

    // Lisää yksittäinen merkintä
    @Insert(onConflict = REPLACE)
    void insert(UniTilasto uniTilasto);

    @Update
    void update(UniTilasto uniTilasto);

    // Poista yksittäinen merkintä
    @Delete
    void delete(UniTilasto uniTilasto);

    // Poista kaikki merkinnät
    @Query("Delete from unitilasto_table")
    void deleteAll();

    // TODO - hae tuntimäärät laskentaa varten
    @Query("select")
    LiveData<List<UniTilasto>> getTunnit();

}
