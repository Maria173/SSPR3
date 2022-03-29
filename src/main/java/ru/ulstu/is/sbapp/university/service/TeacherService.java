package ru.ulstu.is.sbapp.university.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.ulstu.is.sbapp.university.model.Teacher;
import ru.ulstu.is.sbapp.university.model.Subject;
import ru.ulstu.is.sbapp.university.repository.TeacherRepository;
import ru.ulstu.is.sbapp.university.repository.SubjectRepository;
import ru.ulstu.is.sbapp.util.validation.ValidatorUtil;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;
    private final ValidatorUtil validatorUtil;

    public TeacherService(TeacherRepository teacherRepository,
            SubjectRepository subjectRepository,
            ValidatorUtil validatorUtil) {
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
        this.validatorUtil = validatorUtil;
    }

    @Transactional
    public Teacher addTeacher(String firstName, String lastName, int experience) {
        final Teacher teacher = new Teacher(firstName, lastName, experience);
        validatorUtil.validate(teacher);
        return teacherRepository.save(teacher);
    }

    @Transactional(readOnly = true)
    public Teacher findTeacher(Long id) {
        final Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.orElseThrow(() -> new TeacherNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public List<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }

    @Transactional
    public Teacher updateTeacher(Long id, String firstName, String lastName, int experience) {
        final Teacher currentTeacher = findTeacher(id);
        currentTeacher.setFirstName(firstName);
        currentTeacher.setLastName(lastName);
        currentTeacher.setExperience(experience);
        validatorUtil.validate(currentTeacher);
        return teacherRepository.save(currentTeacher);
    }

    @Transactional
    public Teacher deleteTeacher(Long id) {
        final Teacher currentTeacher = findTeacher(id);
        teacherRepository.delete(currentTeacher);
        return currentTeacher;
    }

    @Transactional
    public void deleteAllTeachers() {
        teacherRepository.deleteAll();
    }

    @Transactional
    public Subject addSubject(String name, int hours, Long teacher) {
        final Subject subject = new Subject(name, hours, teacher);
        validatorUtil.validate(subject);
        return subjectRepository.save(subject);
    }

    @Transactional(readOnly = true)
    public Subject findSubject(Long id) {
        final Optional<Subject> subject = subjectRepository.findById(id);
        return subject.orElseThrow(() -> new SubjectNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public List<Subject> findAllSubjects() {
        return subjectRepository.findAll();
    }

    @Transactional
    public Subject updateSubject(Long id, String name, int hours, Long teacher) {
        final Subject currentSubject = findSubject(id);
        currentSubject.setName(name);
        currentSubject.setHours(hours);
        currentSubject.setTeacher(teacher);
        validatorUtil.validate(currentSubject);
        return subjectRepository.save(currentSubject);
    }

    @Transactional
    public Subject deleteSubject(Long id) {
        final Subject currentSubject = findSubject(id);
        subjectRepository.delete(currentSubject);
        return currentSubject;
    }

    @Transactional
    public void deleteAllSubjects() {
        subjectRepository.deleteAll();
    }
}
