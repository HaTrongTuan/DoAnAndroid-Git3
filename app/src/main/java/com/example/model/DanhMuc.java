package com.example.model;

import java.util.List;

public class DanhMuc {

    private String name;
    private List<Teacher> teacher;
    private boolean isFeature;

    public DanhMuc(String name, List<Teacher> teacher, boolean isFeature) {
        this.name = name;
        this.teacher = teacher;
        this.isFeature = isFeature;
    }

    public boolean isFeature() {
        return isFeature;
    }

    public void setFeature(boolean feature) {
        isFeature = feature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Teacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(List<Teacher> teacher) {
        this.teacher = teacher;
    }
}
