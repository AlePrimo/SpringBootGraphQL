package com.graphql.example.services.implementations;

import com.graphql.example.entities.Course;
import com.graphql.example.persistence.ICourseDAO;
import com.graphql.example.services.interfaces.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private ICourseDAO iCourseDAO;



    @Override
    @Transactional(readOnly = true)
    public Course findById(Long id) {
        return iCourseDAO.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return (List<Course>) iCourseDAO.findAll();
    }

    @Override
    @Transactional
    public void createCourse(Course course) {
        iCourseDAO.save(course);

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        iCourseDAO.deleteById(id);

    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        iCourseDAO.save(course);
    }
}
