package ru.ulstu.is.sbapp.university.controller;

import ru.ulstu.is.sbapp.university.model.Teacher;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

public class TeacherDto {
    private long id;

    @NotBlank(message = "First name can't be null or empty")
    private String firstName;

    @NotBlank(message = "Lastname can't be null or empty")
    private String lastName;

    public TeacherDto() {
    }

    public TeacherDto(Teacher teacher) {
        this.id = teacher.getId();
        this.firstName = teacher.getFirstName();
        this.lastName = teacher.getLastName();
    }

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
