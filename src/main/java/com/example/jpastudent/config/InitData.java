package com.example.jpastudent.config;

import com.example.jpastudent.model.Student;
import com.example.jpastudent.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class InitData implements CommandLineRunner
{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception
    {
        Student student = new Student();
        student.setBornDate(LocalDate.of(2000, 10, 11));
        student.setBornTime(LocalTime.now());
        student.setName("Erik");
        studentRepository.save(student);
        student.setName("Bruce");
        studentRepository.save(student);
        studentRepository.save(student);

    }
}
