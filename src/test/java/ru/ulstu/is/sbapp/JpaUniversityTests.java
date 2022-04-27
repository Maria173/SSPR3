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
import ru.ulstu.is.sbapp.university.service.SubjectService;

import java.util.List;

@SpringBootTest
public class JpaUniversityTests {
    private static final Logger log = LoggerFactory.getLogger(JpaUniversityTests.class);

    @Autowired
    private TeacherService teacherService;

    @Test
    void testTeacherCreate() {
        teacherService.deleteAllTeachers();
        final Teacher teacher = teacherService.addTeacher("Иван", "Александров");
        log.info(teacher.toString());
        Assertions.assertNotNull(teacher.getId());

    }

    @Test
    void testTeacherRead() {
        teacherService.deleteAllTeachers();
        final Teacher teacher = teacherService.addTeacher("Иван", "Александров");
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
        teacherService.addTeacher("Иван", "Александров");
        teacherService.addTeacher("Петр", "Петров");
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

    @Autowired
    private SubjectService subjectService;

    @Test
    void testSubjectCreate() {
        subjectService.deleteAllSubjects();
        final Subject subject = subjectService.addSubject("Технологии программирования", 40);
        log.info(subject.toString());
        Assertions.assertNotNull(subject.getId());
    }

    @Test
    void testSubjectRead() {
        subjectService.deleteAllSubjects();
        final Subject subject = subjectService.addSubject("Технологии программирования", 40);
        log.info(subject.toString());
        final Subject findSubject = subjectService.findSubject(subject.getId());
        log.info(findSubject.toString());
        Assertions.assertEquals(subject, findSubject);
    }

    @Test
    void testSubjectReadNotFound() {
        subjectService.deleteAllSubjects();
        Assertions.assertThrows(SubjectNotFoundException.class, () -> subjectService.findSubject(-1L));

    }

    @Test
    void testSubjectReadAll() {
        subjectService.deleteAllSubjects();
        subjectService.addSubject("Технологии программирования", 40);
        subjectService.addSubject("Философия", 25);
        final List<Subject> subject = subjectService.findAllSubjects();
        log.info(subject.toString());
        Assertions.assertEquals(subject.size(), 2);
    }

    @Test
    void testSubjectReadAllEmpty() {
        subjectService.deleteAllSubjects();
        final List<Subject> subjects = subjectService.findAllSubjects();
        log.info(subjects.toString());
        Assertions.assertEquals(subjects.size(), 0);

    }

}
