package com.javatechie.service;

import com.javatechie.dto.Course;
import com.javatechie.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    //RDS DB
    @Autowired
    private CourseRepository courseRepository;



    // Create a new course
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    // Retrieve all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Retrieve a course by id
    public Optional<Course> getCourseById(int id) {
        return courseRepository.findById(id);
    }

    // Update a course
    public boolean updateCourse(int id, Course newCourse) {
        Optional<Course> existingCourseOpt = getCourseById(id);
        if (existingCourseOpt.isPresent()) {
            Course existingCourse = existingCourseOpt.get();
            existingCourse.setName(newCourse.getName());
            existingCourse.setPrice(newCourse.getPrice());
            courseRepository.save(existingCourse);
            return true;
        }
        return false;
    }

    // Delete a course by id
    public boolean deleteCourse(int id) {
        Optional<Course> existingCourseOpt = getCourseById(id);
        if (existingCourseOpt.isPresent()) {
            courseRepository.delete(existingCourseOpt.get());
            return true;
        }
        return false;
    }
}
