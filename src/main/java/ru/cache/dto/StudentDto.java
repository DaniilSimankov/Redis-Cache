package ru.cache.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cache.models.Student;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;

    public static StudentDto from(Student student){
        return StudentDto.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .build();
    }

    public static List<StudentDto> from(List<Student> students){
        return students.stream().map(StudentDto::from).collect(Collectors.toList());
    }
}