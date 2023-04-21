package ru.cache.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cache.models.Student;

public interface StudentsRepository extends JpaRepository<Student, Long> {
}
