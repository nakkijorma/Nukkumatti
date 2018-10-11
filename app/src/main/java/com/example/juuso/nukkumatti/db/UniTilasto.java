package com.example.juuso.nukkumatti.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "unitilasto_table")
public class UniTilasto {

    // Taulukon ID autogeneroidaan
    @PrimaryKey(autoGenerate = true)
    private int uid;

    // Luodaan taulukon kolumnit, ColumnInfo ei välttämätön
    @ColumnInfo(name = "pvm" )
    private String pvm; // TODO - Muuta String päivämäärä arvoksis

    @NonNull
    @ColumnInfo(name = "tunnit")
    private double tunnit;

    @ColumnInfo(name = "fiilis")
    private String fiilis;

    public UniTilasto(String pvm, double tunnit, String fiilis) {
        this.pvm = pvm;
        this.tunnit = tunnit;
        this.fiilis = fiilis;
    }

    // Get ja Set uid:lle
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    // Get ja Set päivämäärälle
    public String getPvm() {
        return pvm;
    }
    /*
    public void setPvm(String pvm) {
        this.pvm = pvm;
    } */

    // Get ja Set tunneille
    public double getTunnit() {
        return tunnit;
    }
/*
    public void setTunnit(double tunnit) {
        this.tunnit = tunnit;
    } */

    // Get ja Set fiilikselle
    public String getFiilis() {
        return fiilis;
    }
/*
    public void setFiilis(String fiilis) {
        this.fiilis = fiilis;
    } */
}
