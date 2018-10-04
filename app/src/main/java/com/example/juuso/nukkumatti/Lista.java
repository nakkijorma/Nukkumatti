package com.example.juuso.nukkumatti;

import java.util.ArrayList;
import java.util.List;

class Lista {
    private List<Olio> oliot;
    private static final Lista ourInstance = new Lista();

    static Lista getInstance() {
        return ourInstance;
    }

    private Lista() {
        oliot = new ArrayList<>();
        oliot.add(new Olio("3/10/2018", 9));
        oliot.add(new Olio("3/11/2018", 7));
    }

    public List<Olio> getOliot() {
        return oliot;

    }
}
