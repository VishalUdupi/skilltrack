package com.skilltrack.repository;

import com.skilltrack.model.Enrollment;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepository {
    private List<Enrollment> enrollments = new ArrayList<>();

    public void addEnrollment(Enrollment enrollment){
        enrollments.add(enrollment);
    }
    public List<Enrollment> getEnrollmentsByStudent(int studentId){
        return enrollments.stream().filter(
                x -> x.getStudentId() == studentId
        ).toList();
    }
    public List<Enrollment> getAllEnrollments(){
        return new ArrayList<>(enrollments);
    }
    public boolean deleteEnrollment(int enrollmentId){
        return enrollments.removeIf(x -> x.getEnrollmentId() == enrollmentId);
    }
}
