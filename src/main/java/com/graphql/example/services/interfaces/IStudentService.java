package com.graphql.example.services.interfaces;


import com.graphql.example.entities.Student;

import java.util.List;

public interface IStudentService  {

    Student findById(Long id);
    List<Student> findAll();
    void createStudent(Student student);
    void deleteById(Long id);
    void updateStudent(Student student);


}
