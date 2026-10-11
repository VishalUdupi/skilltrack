package com.skilltrack.repository;

import com.skilltrack.model.Course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseRepository {
    private Map<Integer, Course> courseMap = new HashMap<>();

    public void addCourse(Course course){
        courseMap.put(course.getCourseId(), course);
    }
    public Course getCourse(int id){
        return courseMap.get(id);
    }
    public List<Course> getAllCourses(){
        return courseMap.values().stream().toList();
    }
    public boolean deleteCourse(int id){
        return courseMap.remove(id) != null;
    }
}
