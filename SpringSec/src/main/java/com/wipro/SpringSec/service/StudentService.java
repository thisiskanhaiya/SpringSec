package com.wipro.SpringSec.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.SpringSec.model.Student;

@Service
public class StudentService {
    List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Alice", 90),
            new Student(2, "Bob", 80),
            new Student(3, "Charlie", 70),
            new Student(4, "David", 60),
            new Student(5, "Eve", 50)
    ));

    public List<Student> getStudents() {
        return students;
    }


    public void addStudent(Student student) {
        students.add(student);
    }

}
