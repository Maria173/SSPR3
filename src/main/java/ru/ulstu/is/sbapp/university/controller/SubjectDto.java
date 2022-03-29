package ru.ulstu.is.sbapp.university.controller;

import ru.ulstu.is.sbapp.university.model.Subject;

public class SubjectDto {
    private final long id;
    private final String name;
    private final int hours;
    private Long teacher_id;

    public SubjectDto(Subject subject) {
        this.id = subject.getId();
        this.name = subject.getName();
        this.hours = subject.getHours();
        this.teacher_id = subject.getTeacher();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHours() {
        return hours;
    }

    public long getTeacher() {
        return teacher_id;
    }
}
