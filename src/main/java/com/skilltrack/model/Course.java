package com.skilltrack.model;

import java.time.LocalDate;

public class Course {
    private int  courseId;
    private String title;
    private String description;
    private int durationHours;
    private LocalDate createdAt;

    public Course(int courseId, String title, String description, int durationHours, LocalDate createdAt) {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.durationHours = durationHours;
        this.createdAt = createdAt;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(int durationHours) {
        this.durationHours = durationHours;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Course{}";
    }
}
