package com.tnsif.studentcourse.controller;

import com.tnsif.studentcourse.entity.Enrollment;
import com.tnsif.studentcourse.service.EnrollmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin(origins = "*")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService){
        this.enrollmentService = enrollmentService;
    }

    // Enroll a student in a course
    @PostMapping("/enroll")
    public Enrollment enrollStudent(@RequestParam Long studentId, @RequestParam Long courseId){
        return enrollmentService.enrollStudent(studentId, courseId);
    }

    // Get all enrollments
    @GetMapping
    public List<Enrollment> getAllEnrollments(){
        return enrollmentService.getAllEnrollments();
    }

    // Delete enrollment
    @DeleteMapping("/{id}")
    public String deleteEnrollment(@PathVariable Long id){
        enrollmentService.deleteEnrollment(id);
        return "Enrollment deleted successfully";
    }
}
