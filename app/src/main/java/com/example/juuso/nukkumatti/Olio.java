package com.example.juuso.nukkumatti;

public class Olio {
    private String pvm;
    private int tunnit;

    public Olio(String pvm, int tunnit) {
        this.pvm = pvm;
        this.tunnit = tunnit;
    }

    public String getPvm() {
        return this.pvm;
    }

    public int getTunnit() {
        return this.tunnit;
    }

    public String toString() {
        return this.pvm + ": " + this.tunnit + "h";
    }
}
