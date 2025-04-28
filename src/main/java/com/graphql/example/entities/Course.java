package com.graphql.example.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder



public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String category;
    String teacher;
    @OneToMany(mappedBy = "course",
               fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               targetEntity = Student.class)
    List<Student> studentList;


}
