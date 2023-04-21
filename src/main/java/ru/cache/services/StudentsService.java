package ru.cache.services;

import ru.cache.dto.StudentDto;

public interface StudentsService {
    StudentDto addStudent(StudentDto student);

    StudentDto updateStudent(Long studentId, StudentDto student);

    void deleteStudent(Long studentId);

    StudentDto getStudent(Long studentId);
}
