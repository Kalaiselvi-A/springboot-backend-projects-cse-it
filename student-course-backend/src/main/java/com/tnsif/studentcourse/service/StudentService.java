package com.tnsif.studentcourse.service;

import com.tnsif.studentcourse.entity.Student;
import com.tnsif.studentcourse.exception.ResourceNotFoundException;
import com.tnsif.studentcourse.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Create student
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    // Get all
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get by ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + id));
    }

    // Update student
    public Student updateStudent(Long id, Student updated) {
        Student existing = getStudentById(id);

        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setDepartment(updated.getDepartment());
        existing.setYear(updated.getYear());
        existing.setPhone(updated.getPhone());
        existing.setAddress(updated.getAddress());
        existing.setDob(updated.getDob());
        existing.setGender(updated.getGender());

        return studentRepository.save(existing);
    }

    // Delete student
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Student not found with ID: " + id);
        }
        studentRepository.deleteById(id);
    }
}
