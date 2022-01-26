package com.turntabl.studentsystem.controller;

import com.turntabl.studentsystem.controller.dtos.StudentUpdateDtos;
import com.turntabl.studentsystem.model.Student;
import com.turntabl.studentsystem.service.StudentService;
import com.turntabl.studentsystem.utils.JsonNullableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static com.turntabl.studentsystem.utils.JsonNullableUtils.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String add(@RequestBody Student student){
        studentService.saveStudent(student);
        return "New student added.";
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable Integer id){
        try{
            Optional<Student> student = studentService.get(id);
            return new ResponseEntity<Student>(student.get(), HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePerson(@PathVariable("id") Integer id, @RequestBody StudentUpdateDtos studentUpdateDtos) {
        Optional<Student> studentOptional = studentService.get(id);
        if (studentOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Student student = studentOptional.get();
        changeIfPresent(studentUpdateDtos.getName(), student::setName);
        changeIfPresent(studentUpdateDtos.getAddress(), student::setAddress);

        studentService.saveStudent(student);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        studentService.delete(id);
        return "Deleted student with id " + id;
    }
}
