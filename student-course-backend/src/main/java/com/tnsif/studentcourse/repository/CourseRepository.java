package com.tnsif.studentcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tnsif.studentcourse.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findByCourseCode(String courseCode);

}
