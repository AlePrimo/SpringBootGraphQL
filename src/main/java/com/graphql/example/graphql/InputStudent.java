package com.graphql.example.graphql;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

public class InputStudent {

    String name;
    String lastName;
    Integer age;
    String courseId;



}
