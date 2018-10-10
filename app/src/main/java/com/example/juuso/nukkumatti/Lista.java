package com.example.juuso.nukkumatti;

import java.util.ArrayList;
import java.util.List;

public class Lista {
    public ArrayList<Olio> oliot;

    public Lista() {
        oliot = new ArrayList<>();
        oliot.add(new Olio("3/10/2018", 9));
        oliot.add(new Olio("3/11/2018", 7.2));
    }

    public ArrayList<Olio> getOliot() {
        return oliot;
    }

}
