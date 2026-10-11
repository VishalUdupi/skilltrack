package com.skilltrack;

import com.skilltrack.exceptions.CourseNotFoundException;
import com.skilltrack.exceptions.EnrollmentException;
import com.skilltrack.exceptions.UserNotFoundException;
import com.skilltrack.model.Course;
import com.skilltrack.model.Enrollment;
import com.skilltrack.model.User;
import com.skilltrack.services.*;
import com.skilltrack.utils.InputUtil;

import java.time.LocalDate;
import java.util.List;

public class Main {

    private static UserService userService = new UserService();
    private static CourseService courseService = new CourseService();
    private static EnrollmentService enrollmentService =
            new EnrollmentService(userService, courseService);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n------ SkillTrack Menu ------");
            System.out.println("1. Add User");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student");
            System.out.println("4. View Enrollments");
            System.out.println("5. Exit");

            int choice = InputUtil.readInt("Enter choice: ");

            switch (choice) {
                case 1 -> addUserMenu();
                case 2 -> addCourseMenu();
                case 3 -> enrollMenu();
                case 4 -> showAllEnrollments();
                case 5 -> {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void addUserMenu() {
        int id = InputUtil.readInt("Enter User ID: ");
        String name = InputUtil.readString("Enter User Name: ");
        String email = InputUtil.readString("Enter Email: ");

        User user = new User(id, name, email, LocalDate.now());
        userService.addUser(user);
        System.out.println("User added successfully!");
    }
    private static void addCourseMenu() {
        int id = InputUtil.readInt("Enter Course ID: ");
        String title = InputUtil.readString("Enter Course Title: ");
        String description = InputUtil.readLine("Enter Course Description: ");
        int duration = InputUtil.readInt("Enter Duration Hours: ");

        Course course = new Course(id, title, description, duration, LocalDate.now());
        courseService.addCourse(course);
        System.out.println("Course added successfully!");
    }

    private static void enrollMenu() {
        int studentId = InputUtil.readInt("Enter Student ID: ");
        int courseId = InputUtil.readInt("Enter Course ID: ");

        try {
            enrollmentService.enrollStudent(studentId, courseId);
            System.out.println("Enrollment successful!");
        } catch (UserNotFoundException | CourseNotFoundException | EnrollmentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void showAllEnrollments() {
        List<Enrollment> list = enrollmentService.getAllEnrollments();
        if (list.isEmpty()) {
            System.out.println("No enrollments found.");
            return;
        }
        list.forEach(System.out::println);
    }
}