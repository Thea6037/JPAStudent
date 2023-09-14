package com.example.jpastudent.controller;

import com.example.jpastudent.model.Student;
import com.example.jpastudent.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentRestController
{
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> listStudents()
    {
       return studentRepository.findAll();
    }

    @GetMapping("/studentid/{id}")
    public Optional<Student> getStudent(@PathVariable int id)
    {
        return studentRepository.findById(id);
    }

    @GetMapping("studentname/{name}") public List<Student> getAllStudentsByName(@PathVariable String name) { return studentRepository.findAllByName(name); }

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student postStudent(@RequestBody Student student)
    {
        System.out.println(student);
        return studentRepository.save(student);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> putStudent(@PathVariable int id, @RequestBody Student student)
    {
        Optional<Student> orgStudent = studentRepository.findById(id);
        if(orgStudent.isPresent())
        {
            student.setId(id);
            studentRepository.save(student);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Student(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id)
    {
        Optional<Student> orgStudent = studentRepository.findById(id);
        if(orgStudent.isPresent())
        {
            studentRepository.deleteById(id);
            return ResponseEntity.ok("Student deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
    }
}
