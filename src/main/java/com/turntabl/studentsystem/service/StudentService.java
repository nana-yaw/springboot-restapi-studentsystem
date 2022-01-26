package com.turntabl.studentsystem.service;

import com.turntabl.studentsystem.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public Optional<Student> get(Integer id);
    public void delete(Integer id);
}
