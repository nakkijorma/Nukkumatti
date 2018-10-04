package com.example.juuso.nukkumatti;

public class Olio {
    private String pvm;
    private double tunnit;

    public Olio(String pvm, double tunnit) {
        this.pvm = pvm;
        this.tunnit = tunnit;
    }

    public String getPvm() {
        return this.pvm;
    }

    public double getTunnit() {
        return this.tunnit;
    }

    public String toString() {
        return this.pvm + "\n" + this.tunnit + " tuntia";
    }
}
