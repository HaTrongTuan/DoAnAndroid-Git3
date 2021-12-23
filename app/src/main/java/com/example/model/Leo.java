package com.example.model;

public class Leo {
    private String Leo;
    private String DetailLeo1;
    private String DetailLeo2;
    private boolean Expandable;

    public Leo(String leo, String detailLeo1, String detailLeo2) {
        Leo = leo;
        DetailLeo1 = detailLeo1;
        DetailLeo2 = detailLeo2;
        Expandable = false;

    }

    public String getLeo() {
        return Leo;
    }

    public void setLeo(String leo) {
        Leo = leo;
    }

    public String getDetailLeo1() {
        return DetailLeo1;
    }

    public void setDetailLeo1(String detailLeo1) {
        DetailLeo1 = detailLeo1;
    }

    public String getDetailLeo2() {
        return DetailLeo2;
    }

    public void setDetailLeo2(String detailLeo2) {
        DetailLeo2 = detailLeo2;
    }

    public boolean isExpandable() {
        return Expandable;
    }

    public void setExpandable(boolean expandable) {
        Expandable = expandable;
    }
}
