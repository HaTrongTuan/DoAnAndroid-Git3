package com.example.model;

public class Teacher{
    private int Ava;
    private String Name;

    public Teacher(int ava, String name) {
        Ava = ava;
        Name = name;
    }



    public void setAva(int ava) {
        Ava = ava;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAva() {
        return Ava;
    }
}
