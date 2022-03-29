package ru.ulstu.is.sbapp.university.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import ru.ulstu.is.sbapp.university.model.Teacher;
import ru.ulstu.is.sbapp.university.model.Subject;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class TeacherService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Teacher addTeacher(String firstName, String lastName, int experience) {
        if (!StringUtils.hasText(firstName) || !StringUtils.hasText(lastName)
                || !StringUtils.hasText(Integer.toString(experience))) {
            throw new IllegalArgumentException("Teacher name is null or empty");
        }
        final Teacher teacher = new Teacher(firstName, lastName, experience);
        em.persist(teacher);
        return teacher;
    }

    @Transactional(readOnly = true)
    public Teacher findTeacher(Long id) {
        final Teacher teacher = em.find(Teacher.class, id);
        if (teacher == null) {
            throw new EntityNotFoundException(String.format("Teacher with id [%s] is not found", id));
        }
        return teacher;
    }

    @Transactional(readOnly = true)
    public List<Teacher> findAllTeachers() {
        return em.createQuery("select s from Teacher s", Teacher.class).getResultList();
    }

    @Transactional
    public Teacher updateTeacher(Long id, String firstName, String lastName, int experience) {
        if (!StringUtils.hasText(firstName) || !StringUtils.hasText(lastName)
                || !StringUtils.hasText(Integer.toString(experience))) {
            throw new IllegalArgumentException("Teacher name is null or empty");
        }
        final Teacher currentTeacher = findTeacher(id);
        currentTeacher.setFirstName(firstName);
        currentTeacher.setLastName(lastName);
        currentTeacher.setExperience(experience);
        return em.merge(currentTeacher);
    }

    @Transactional
    public Teacher deleteTeacher(Long id) {
        final Teacher currentTeacher = findTeacher(id);
        em.remove(currentTeacher);
        return currentTeacher;
    }

    @Transactional
    public void deleteAllTeachers() {
        em.createQuery("delete from Teacher").executeUpdate();
    }

    @Transactional
    public Subject addSubject(String name, int hours, Long teacher) {
        if (!StringUtils.hasText(name) || !StringUtils.hasText(Integer.toString(hours))) {
            throw new IllegalArgumentException("Subject name is null or empty");
        }
        final Subject subject = new Subject(name, hours, teacher);
        em.persist(subject);
        return subject;
    }

    @Transactional(readOnly = true)
    public Subject findSubject(Long id) {
        final Subject subject = em.find(Subject.class, id);
        if (subject == null) {
            throw new EntityNotFoundException(String.format("Subject with id [%s] is not found", id));
        }
        return subject;
    }

    @Transactional(readOnly = true)
    public List<Subject> findAllSubjects() {
        return em.createQuery("select s from Subject s", Subject.class).getResultList();
    }

    @Transactional
    public Subject updateSubject(Long id, String name, int hours, Long teacher) {
        if (!StringUtils.hasText(name) || !StringUtils.hasText(Integer.toString(hours))) {
            throw new IllegalArgumentException("Subject name is null or empty");
        }
        final Subject currentSubject = findSubject(id);
        currentSubject.setName(name);
        currentSubject.setHours(hours);
        currentSubject.setTeacher(teacher);
        return em.merge(currentSubject);
    }

    @Transactional
    public Subject deleteSubject(Long id) {
        final Subject currentSubject = findSubject(id);
        em.remove(currentSubject);
        return currentSubject;
    }

    @Transactional
    public void deleteAllSubjects() {
        em.createQuery("delete from Subject").executeUpdate();
    }
}
