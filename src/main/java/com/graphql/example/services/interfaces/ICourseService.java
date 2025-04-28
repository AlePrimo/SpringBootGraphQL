package com.graphql.example.services.interfaces;

import com.graphql.example.entities.Course;


import java.util.List;

public interface ICourseService {


    Course findById(Long id);
    List<Course> findAll();
    void createCourse(Course course);
    void deleteById(Long id);
    void updateCourse(Course course);



}
