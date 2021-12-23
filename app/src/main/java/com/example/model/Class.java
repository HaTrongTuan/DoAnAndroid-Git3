package com.example.model;

import android.widget.ImageView;

public class Class {
    int Thumb;
    String tenbaihoc, Thamgia, gio, ngay, nameGV;

    public Class(int thumb, String tenbaihoc, String thamgia, String gio, String ngay, String nameGV) {
        Thumb = thumb;
        this.tenbaihoc = tenbaihoc;
        Thamgia = thamgia;
        this.gio = gio;
        this.ngay = ngay;
        this.nameGV = nameGV;
    }

    public int getThumb() {
        return Thumb;
    }

    public void setThumb(int thumb) {
        Thumb = thumb;
    }

    public String getTenbaihoc() {
        return tenbaihoc;
    }

    public void setTenbaihoc(String tenbaihoc) {
        this.tenbaihoc = tenbaihoc;
    }

    public String getThamgia() {
        return Thamgia;
    }

    public void setThamgia(String thamgia) {
        Thamgia = thamgia;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getNameGV() {
        return nameGV;
    }

    public void setNameGV(String nameGV) {
        this.nameGV = nameGV;
    }
}
