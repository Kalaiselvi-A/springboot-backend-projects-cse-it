package com.tnsif.studentcourse.service;

import com.tnsif.studentcourse.entity.Course;
import com.tnsif.studentcourse.exception.ResourceNotFoundException;
import com.tnsif.studentcourse.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Create course
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    // Get all
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Get by ID
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with ID: " + id));
    }

    // Update course
    public Course updateCourse(Long id, Course updated) {
        Course existing = getCourseById(id);

        existing.setCourseCode(updated.getCourseCode());
        existing.setCourseName(updated.getCourseName());
        existing.setDescription(updated.getDescription());
        existing.setCredits(updated.getCredits());
        existing.setSemester(updated.getSemester());
        existing.setDepartment(updated.getDepartment());

        return courseRepository.save(existing);
    }

    // Delete course
    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Course not found with ID: " + id);
        }
        courseRepository.deleteById(id);
    }
}
