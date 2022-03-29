package ru.ulstu.is.sbapp.university.model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column()
    String name;
    int hours;
    Long teacher_id;

    public Long getTeacher() {
        return teacher_id;
    }

    public void setTeacher(Long teacher_id) {
        this.teacher_id = teacher_id;
    }

    @ManyToMany
    private List<Subject> teacher;

    public Subject() {

    }

    public Subject(String name, int hours, Long teacher_id) {
        this.name = name;
        this.hours = hours;
        this.teacher_id = teacher_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Subject subject = (Subject) o;
        return Objects.equals(id, subject.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hours='" + hours + '\'' +
                ", teacher'" + teacher_id + '\'' +
                '}';
    }
}
