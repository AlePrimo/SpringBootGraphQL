package com.graphql.example.services.implementations;


import com.graphql.example.entities.Student;
import com.graphql.example.persistence.IStudentDAO;
import com.graphql.example.services.interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDAO iStudentDAO;

    @Override
    @Transactional(readOnly = true)
    public Student findById(Long id) {
        return  iStudentDAO.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return (List<Student>) iStudentDAO.findAll();
    }

    @Override
    @Transactional
    public void createStudent(Student student) {
        iStudentDAO.save(student);

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        iStudentDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        iStudentDAO.save(student);
    }
}
