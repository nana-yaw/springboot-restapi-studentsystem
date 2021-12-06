package com.turntabl.studentsystem.service;

import com.turntabl.studentsystem.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public Student get(Integer id);
    public Student patch(Integer id, Map<String, Object> changes);
    public void delete(Integer id);
}
