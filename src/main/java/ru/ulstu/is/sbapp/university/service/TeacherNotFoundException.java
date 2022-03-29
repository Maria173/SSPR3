package ru.ulstu.is.sbapp.university.service;

public class TeacherNotFoundException extends RuntimeException {
    public TeacherNotFoundException(Long id) {
        super(String.format("Teacher with id [%s] is not found", id));
    }
}
