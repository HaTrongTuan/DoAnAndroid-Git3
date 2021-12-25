package com.example.model;

import java.io.Serializable;

public class Teacher {
    private int Ava;
    private String NameGV;


    public Teacher(int ava, String nameGV) {
        Ava = ava;
        NameGV = nameGV;

    }

    public int getAva() {
        return Ava;
    }

    public void setAva(int ava) {
        Ava = ava;
    }

    public String getNameGV() {
        return NameGV;
    }

    public void setNameGV(String nameGV) {
        NameGV = nameGV;
    }


}
