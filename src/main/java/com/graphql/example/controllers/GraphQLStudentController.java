package com.graphql.example.controllers;

import com.graphql.example.entities.Course;
import com.graphql.example.entities.Student;
import com.graphql.example.graphql.InputStudent;
import com.graphql.example.services.interfaces.ICourseService;
import com.graphql.example.services.interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLStudentController {

    @Autowired
    private IStudentService iStudentService;
    @Autowired
    private ICourseService iCourseService;

    @QueryMapping(name = "findStudentById")  //CON ESTA ANOTACION DEFINIMOS A QUE METODO DE GRAPHQL SE ESTA LLAMANDO , EN EL CASO QUE NO COINCIDA CON EL METODO DE ESTE CONTROLLER
    public Student findById(@Argument(name = "studentId") String id){  //CON ARGUMENT ESPECIFICAMOS EL ARGUMENTO QUE HAY QUE PASAR, Y SI NO COINCIDEN LOS NOMBRES LO DEFINIMOS
        Long studentId = Long.parseLong(id);
        return iStudentService.findById(studentId);
    }


@QueryMapping(name = "findAllStudents")
    public List<Student> findAll(){
        return iStudentService.findAll();
}

@MutationMapping //EN ESTE CASO  COINCIDEN LOS NOMBRES DE LOS METODOS TANTO EN GRAPHQL COMO AQUI
public Student createStudent(@Argument InputStudent inputStudent){

        Student student = new Student();

        student.setName(inputStudent.getName());
        student.setLastName(inputStudent.getLastName());
        student.setAge(inputStudent.getAge());

        Course course = iCourseService.findById(Long.parseLong(inputStudent.getCourseId()));
        student.setCourse(course);

        iStudentService.createStudent(student);

        return student;
}


@MutationMapping
public String deleteStudentById(@Argument String studentId){
       iStudentService.deleteById(Long.parseLong(studentId));
       return "Estudiante eliminado";
}



@MutationMapping
public String updateStudent(@Argument String idStudent, @Argument InputStudent inputStudent){
        Student student = iStudentService.findById(Long.parseLong(idStudent));
        student.setName(inputStudent.getName());
        student.setAge(inputStudent.getAge());
        student.setLastName(inputStudent.getLastName());
        student.setCourse(iCourseService.findById(Long.parseLong(inputStudent.getCourseId())));
        iStudentService.updateStudent(student);

        return "Alumno actualizado";
}







}
