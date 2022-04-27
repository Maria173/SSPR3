package ru.ulstu.is.sbapp.university.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ulstu.is.sbapp.university.model.Subject;
import ru.ulstu.is.sbapp.university.repository.SubjectRepository;
import ru.ulstu.is.sbapp.util.validation.ValidatorUtil;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final ValidatorUtil validatorUtil;

    public SubjectService(SubjectRepository subjectRepository, ValidatorUtil validatorUtil) {
        this.subjectRepository = subjectRepository;
        this.validatorUtil = validatorUtil;
    }

    @Transactional
    public Subject addSubject(String name, int hours) {
        final Subject subject = new Subject(name, hours);
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
    public Subject updateSubject(Long id, String name, int hours) {
        final Subject currentSubject = findSubject(id);
        currentSubject.setName(name);
        currentSubject.setHours(hours);
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