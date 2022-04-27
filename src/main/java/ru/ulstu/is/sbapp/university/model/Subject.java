package ru.ulstu.is.sbapp.university.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name can't be null or empty")
    String name;

    int hours;

    @ManyToMany(mappedBy = "subjects")
    private List<Teacher> teacher;

    public Subject() {
    }

    public Subject(String name, int hours) {
        this.name = name;
        this.hours = hours;
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
                '}';
    }
}
