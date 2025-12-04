package com.tnsif.studentcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tnsif.studentcourse.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByEmail(String email);

}
