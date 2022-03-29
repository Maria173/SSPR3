package ru.ulstu.is.sbapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ru.ulstu.is.sbapp.university.model.Teacher;
import ru.ulstu.is.sbapp.university.service.TeacherNotFoundException;
import ru.ulstu.is.sbapp.university.service.TeacherService;
import ru.ulstu.is.sbapp.university.model.Subject;
import ru.ulstu.is.sbapp.university.service.SubjectNotFoundException;

import java.util.List;

@SpringBootTest
public class JpaUniversityTests {
    private static final Logger log = LoggerFactory.getLogger(JpaUniversityTests.class);

    @Autowired
    private TeacherService teacherService;

    @Test
    void testTeacherCreate() {
        teacherService.deleteAllTeachers();
        final Teacher teacher = teacherService.addTeacher("Иван", "Александров", 3);
        log.info(teacher.toString());
        Assertions.assertNotNull(teacher.getId());

    }

    @Test
    void testTeacherRead() {
        teacherService.deleteAllTeachers();
        final Teacher teacher = teacherService.addTeacher("Иван", "Александров", 3);
        log.info(teacher.toString());
        final Teacher findTeacher = teacherService.findTeacher(teacher.getId());
        log.info(findTeacher.toString());
        Assertions.assertEquals(teacher, findTeacher);

    }

    @Test
    void testTeacherReadNotFound() {
        teacherService.deleteAllTeachers();
        Assertions.assertThrows(TeacherNotFoundException.class, () -> teacherService.findTeacher(-1L));

    }

    @Test
    void testTeacherReadAll() {
        teacherService.deleteAllTeachers();
        teacherService.addTeacher("Иван", "Александров", 3);
        teacherService.addTeacher("Петр", "Петров", 10);
        final List<Teacher> teachers = teacherService.findAllTeachers();
        log.info(teachers.toString());
        Assertions.assertEquals(teachers.size(), 2);

    }

    @Test
    void testTeacherReadAllEmpty() {
        teacherService.deleteAllTeachers();
        final List<Teacher> teachers = teacherService.findAllTeachers();
        log.info(teachers.toString());
        Assertions.assertEquals(teachers.size(), 0);

    }

    @Test
    void testSubjectCreate() {
        teacherService.deleteAllSubjects();
        teacherService.deleteAllTeachers();
        Long teacher = teacherService.addTeacher("Иван", "Александров", 3).getId();
        final Subject subject = teacherService.addSubject("Технологии программирования", 40, teacher);
        log.info(subject.toString());
        Assertions.assertNotNull(subject.getId());

    }

    @Test
    void testSubjectRead() {
        teacherService.deleteAllSubjects();
        teacherService.deleteAllTeachers();
        Teacher teacher = teacherService.addTeacher("Иван", "Александров", 3);
        final Subject subject = teacherService.addSubject("Технологии программирования", 40, teacher.getId());
        log.info(subject.toString());
        final Subject findSubject = teacherService.findSubject(subject.getId());
        log.info(findSubject.toString());
        Assertions.assertEquals(subject, findSubject);

    }

    @Test
    void testSubjectReadNotFound() {
        teacherService.deleteAllSubjects();
        teacherService.deleteAllTeachers();
        Assertions.assertThrows(SubjectNotFoundException.class, () -> teacherService.findSubject(-1L));

    }

    @Test
    void testSubjectReadAll() {
        teacherService.deleteAllSubjects();
        teacherService.deleteAllTeachers();
        Teacher teacher = teacherService.addTeacher("Иван", "Александров", 3);
        teacherService.addSubject("Технологии программирования", 40, teacher.getId());
        teacherService.addSubject("Философия", 25, teacher.getId());
        final List<Subject> subjects = teacherService.findAllSubjects();
        log.info(subjects.toString());
        Assertions.assertEquals(subjects.size(), 2);

    }

    @Test
    void testSubjectReadAllEmpty() {
        teacherService.deleteAllSubjects();
        teacherService.deleteAllTeachers();
        final List<Subject> subjects = teacherService.findAllSubjects();
        log.info(subjects.toString());
        Assertions.assertEquals(subjects.size(), 0);

    }

}
