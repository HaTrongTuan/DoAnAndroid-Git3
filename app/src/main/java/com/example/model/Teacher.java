package com.example.model;

public class Teacher{
    private int Ava;
    private String Name, NgaySinh, SDT;

    public Teacher(int ava, String name, String ngaySinh, String SDT) {
        Ava = ava;
        Name = name;
        NgaySinh = ngaySinh;
        this.SDT = SDT;
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

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public int getAva() {
        return Ava;
    }
}
