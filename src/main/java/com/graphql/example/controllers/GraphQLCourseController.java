package com.graphql.example.controllers;


import com.graphql.example.entities.Course;

import com.graphql.example.entities.Student;
import com.graphql.example.graphql.InputCourse;
import com.graphql.example.services.interfaces.ICourseService;
import com.graphql.example.services.interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLCourseController {

    @Autowired
    private ICourseService iCourseService;

    @Autowired
    private IStudentService iStudentService;


    @QueryMapping
    public Course findCourseById(@Argument String courseId){
        Course course = iCourseService.findById(Long.parseLong(courseId));
        return course;

    }


    @QueryMapping
    public List<Course> findAllCourses(){
        return iCourseService.findAll();
    }

    @MutationMapping
    public Course createCourse(@Argument InputCourse inputCourse){
        Course course = new Course();
        course.setName(inputCourse.getName());
        course.setCategory(inputCourse.getCategory());
        course.setTeacher(inputCourse.getTeacher());
        iCourseService.createCourse(course);
        return course;
    }

    @MutationMapping
    public String updateCourse(@Argument String courseId, @Argument InputCourse inputCourse){
        Course course = iCourseService.findById(Long.parseLong(courseId));

        course.setName(inputCourse.getName());
        course.setCategory(inputCourse.getCategory());
        course.setTeacher(inputCourse.getTeacher());
        iCourseService.updateCourse(course);
        return "Los datos del curso se han actualizado";
    }

    @MutationMapping
    public String deleteCourseById(@Argument String courseId){
        iCourseService.deleteById(Long.parseLong(courseId));
        return "El curso se ha eliminado";
    }


















}
