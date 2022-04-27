package ru.ulstu.is.sbapp.university.controller;

import ru.ulstu.is.sbapp.university.model.Subject;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

public class SubjectDto {
    private long id;

    @NotBlank(message = "Transaction date can't be null or empty")
    private String name;

    private int hours;

    public SubjectDto() {
    }

    public SubjectDto(Subject subject) {
        this.id = subject.getId();
        this.name = subject.getName();
        this.hours = subject.getHours();
    }

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
