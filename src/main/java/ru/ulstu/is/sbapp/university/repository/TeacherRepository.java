package ru.ulstu.is.sbapp.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ulstu.is.sbapp.university.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
