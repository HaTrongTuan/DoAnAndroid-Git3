package com.example.model;

public class MNews {
    private int Cover;
    private String Tittle;
    private String Viewer;
    private String Time;
    private boolean isFeature;

    public String getTittle() {
        return Tittle;
    }

    public void setTittle(String tittle) {
        Tittle = tittle;
    }



    public boolean isFeature() {
        return isFeature;
    }

    public void setFeature(boolean feature) {
        isFeature = feature;
    }

    public MNews(int cover, String tittle, String viewer, boolean isFeature) {
        Cover = cover;
        Tittle = tittle;
        Viewer = viewer;
        this.isFeature = isFeature;
    }

    public int getCover() {
        return Cover;
    }

    public void setCover(int cover) {
        Cover = cover;
    }

    public String getViewer() {
        return Viewer;
    }

    public void setViewer(String viewer) {
        Viewer = viewer;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
