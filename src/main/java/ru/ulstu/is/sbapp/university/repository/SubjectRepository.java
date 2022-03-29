package ru.ulstu.is.sbapp.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ulstu.is.sbapp.university.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
