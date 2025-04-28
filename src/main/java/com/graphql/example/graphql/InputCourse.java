package com.graphql.example.graphql;

import com.graphql.example.entities.Student;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

public class InputCourse {

    String name;
    String category;
    String teacher;


}
