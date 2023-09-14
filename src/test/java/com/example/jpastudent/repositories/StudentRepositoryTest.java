package com.example.jpastudent.repositories;

import com.example.jpastudent.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest
{
    @Autowired
    StudentRepository studentRepository;

    /*@Test
    void testOneBruce()
    {
        List<Student> lst = studentRepository.findAllByName("Bruce");
        assertEquals(1, lst.size());
    }

    @Test
    void testOneTim()
    {
        Student student1 = new Student();
        student1.setBornDate(LocalDate.now());
        student1.setBornTime(LocalTime.now());
        student1.setName("Tim");
        studentRepository.save(student1);

        List<Student> lst = studentRepository.findAllByName("Tim");

        assertEquals(1, lst.size());
    }

    @Test
    void testOneStudent(){
        List<Student> lst = studentRepository.findAll();
        assertEquals(1, lst.size());
    }*/

}