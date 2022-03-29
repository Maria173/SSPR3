package ru.ulstu.is.sbapp.university.controller;

import ru.ulstu.is.sbapp.university.model.Teacher;

public class TeacherDto {
    private final long id;
    private final String name;
    private final int experience;

    public TeacherDto(Teacher teacher) {
        this.id = teacher.getId();
        this.name = String.format("%s %s", teacher.getFirstName(), teacher.getLastName());
        this.experience = teacher.getExperience();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }
}
