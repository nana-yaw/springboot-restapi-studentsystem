package com.turntabl.studentsystem.service;

import com.turntabl.studentsystem.model.Student;
import com.turntabl.studentsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

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
    public Student get(Integer id) {
        return studentRepository.findById(id).get();
    }

    public void delete(Integer id){
        studentRepository.deleteById(id);
    }

    public Student patch(Integer id, Map<String, Object> changes){

        //Fetch the data from the database
        Student student = studentRepository.findById(id).get();

        //apply the changes to the REST model.
        changes.forEach(
                (change, value) -> {
                    switch (change){
                        case "Name": student.setName((String) value); break;
                        case "Address": student.setAddress((String) value); break;
                    }
                }
        );
        return student;
    }
}
