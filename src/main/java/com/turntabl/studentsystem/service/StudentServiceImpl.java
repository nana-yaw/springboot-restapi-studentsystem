package com.turntabl.studentsystem.service;

import com.turntabl.studentsystem.model.Student;
import com.turntabl.studentsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> get(Integer id) {
        return Optional.of(studentRepository.findById(id).get());
    }

    public void delete(Integer id){
        studentRepository.deleteById(id);
    }
}
