package com.skilltrack.services;

import com.skilltrack.exceptions.CourseNotFoundException;
import com.skilltrack.model.Course;
import com.skilltrack.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    CourseRepository courseRepository = new CourseRepository();
    public void addCourse(Course course){
        courseRepository.addCourse(course);
    }
    public Course getCourseById(int id) throws CourseNotFoundException{
        Course course = courseRepository.getCourse(id);
        if(course == null){
            throw new CourseNotFoundException("Course not found");
        }
        return course;
    }
    public List<Course> getAllCourses(){
        return courseRepository.getAllCourses();
    }
    public void deleteCourse(int id) throws CourseNotFoundException{
        boolean deleted = courseRepository.deleteCourse(id);
        if (!deleted) {
            throw new CourseNotFoundException("Course not found");
        }
    }
}
