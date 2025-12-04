package com.tnsif.studentcourse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tnsif.studentcourse.entity.Course;
import com.tnsif.studentcourse.entity.Enrollment;
import com.tnsif.studentcourse.entity.Student;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    List<Enrollment> findByStudent(Student student);

    List<Enrollment> findByCourse(Course course);

    boolean existsByStudentAndCourse(Student student, Course course);
}
