package ru.ulstu.is.sbapp.university.service;

public class SubjectNotFoundException extends RuntimeException {
    public SubjectNotFoundException(Long id) {
        super(String.format("Subject with id [%s] is not found", id));
    }
}
