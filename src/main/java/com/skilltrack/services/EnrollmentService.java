package com.skilltrack.services;

import com.skilltrack.exceptions.CourseNotFoundException;
import com.skilltrack.exceptions.EnrollmentException;
import com.skilltrack.exceptions.UserNotFoundException;
import com.skilltrack.model.Enrollment;
import com.skilltrack.repository.EnrollmentRepository;

import java.time.LocalDate;
import java.util.List;


public class EnrollmentService {
        UserService userService;
        CourseService courseService;
        EnrollmentRepository enrollmentRepository = new EnrollmentRepository();

    public EnrollmentService(UserService userService, CourseService courseService) {
        this.userService = userService;
        this.courseService = courseService;
    }

    public void enrollStudent(int studentId, int courseId) throws UserNotFoundException, CourseNotFoundException, EnrollmentException {
            if(userService.getUserById(studentId) == null){
                throw new UserNotFoundException("User not found");
            }
            if(courseService.getCourseById(courseId) == null){
                throw new CourseNotFoundException("Course not found");
            }

            boolean alreadyEnrolled = enrollmentRepository.getAllEnrollments()
                    .stream()
                    .anyMatch(enrollment ->
                            enrollment.getStudentId() == studentId && enrollment.getCourseId() == courseId
                    );

            if (alreadyEnrolled) {
                throw new EnrollmentException("Student is already enrolled to this course");
            }

            int eId = enrollmentRepository.getAllEnrollments().size()+1;
            Enrollment enrollment = new Enrollment(
                    eId,
                    studentId,
                    courseId,
                    LocalDate.now(),
                    "ACTIVE"
            );
            enrollmentRepository.addEnrollment(enrollment);
        }

        public List<Enrollment> getEnrollmentsByStudent(int studentId) throws UserNotFoundException{
            if (userService.getUserById(studentId) == null){
                throw new UserNotFoundException("User not found");
            }
            return enrollmentRepository.getEnrollmentsByStudent(studentId);
        }

        public void markCourseCompleted(int enrollmentId) throws EnrollmentException{
            Enrollment enrollment = enrollmentRepository.getAllEnrollments()
                    .stream()
                    .filter(e -> e.getEnrollmentId() == enrollmentId)
                    .findFirst()
                    .orElseThrow(() -> new EnrollmentException("Enrollment not found"));

            enrollment.setStatus("COMPLETED");
        }

        public List<Enrollment> getAllEnrollments(){
            return enrollmentRepository.getAllEnrollments();
        }
    }
