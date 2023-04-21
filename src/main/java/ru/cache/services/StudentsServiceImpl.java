package ru.cache.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cache.dto.StudentDto;
import ru.cache.models.Student;
import ru.cache.repositories.StudentsRepository;

@Service
@RequiredArgsConstructor
public class StudentsServiceImpl implements StudentsService {

    private final StudentsRepository studentsRepository;

    @Override
    public StudentDto addStudent(StudentDto student) {
        Student newStudent = Student.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .build();

        studentsRepository.save(newStudent);

        return StudentDto.from(newStudent);
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto student) {
        Student existedStudent = studentsRepository.getById(studentId);
        existedStudent.setFirstName(student.getFirstName());
        existedStudent.setLastName(student.getLastName());
        studentsRepository.save(existedStudent);
        return StudentDto.from(existedStudent);
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student = studentsRepository.getById(studentId);
        student.setIsDeleted(true);
        studentsRepository.save(student);
    }

    @Override
    public StudentDto getStudent(Long studentId) {
        return StudentDto.from(studentsRepository.getById(studentId));
    }
}
