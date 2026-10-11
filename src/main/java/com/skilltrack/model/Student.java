package com.skilltrack.model;

import java.time.LocalDate;

public class Student extends User{
    private String level;
    private double progress;

    public Student(int id, String name, String email, LocalDate createdAt, String level, double progress) {
        super(id, name, email, createdAt);
        this.level = level;
        this.progress = progress;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void updateProgress(double value){

    }
}
