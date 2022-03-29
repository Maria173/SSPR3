package ru.ulstu.is.sbapp.university.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.ulstu.is.sbapp.university.model.Teacher;
import ru.ulstu.is.sbapp.university.model.Subject;
import ru.ulstu.is.sbapp.university.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable Long id) {
        return teacherService.findTeacher(id);
    }

    @GetMapping("/")
    public List<Teacher> getTeachers() {
        return teacherService.findAllTeachers();
    }

    @PostMapping("/")
    public Teacher createTeacher(@RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("experience") int experience) {
        return teacherService.addTeacher(firstName, lastName, experience);
    }

    @PatchMapping("/{id}")
    public Teacher updateTeacher(@PathVariable Long id,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("experience") int experience) {
        return teacherService.updateTeacher(id, firstName, lastName, experience);
    }

    @DeleteMapping("/{id}")
    public Teacher deleteTeacher(@PathVariable Long id) {
        return teacherService.deleteTeacher(id);
    }

    @GetMapping("/c{id}")
    public Subject getSubject(@PathVariable Long id) {
        return teacherService.findSubject(id);
    }

    @GetMapping("/c")
    public List<Subject> getSubjects() {
        return teacherService.findAllSubjects();
    }

    @PostMapping("/c")
    public Subject createSubject(@RequestParam("name") String name,
            @RequestParam("hours") int hours,
            @RequestParam("teacherId") Long teacherId) {
        return teacherService.addSubject(name, hours, teacherId);
    }

    @PatchMapping("/c{id}")
    public Subject updateSubject(@PathVariable Long id,
            @RequestParam("name") String name,
            @RequestParam("hours") int hours,
            @RequestParam("teacherId") Long teacherId) {
        return teacherService.updateSubject(id, name, hours, teacherId);
    }

    @GetMapping("/test/{id}")
    public Subject updateTestSubject(@PathVariable Long id,
            @RequestParam("name") String name,
            @RequestParam("hours") int hours,
            @RequestParam("teacherId") Long teacherId) {
        return teacherService.updateSubject(id, name, hours, teacherId);
    }

    @DeleteMapping("/c{id}")
    public Subject deleteSubject(@PathVariable Long id) {
        return teacherService.deleteSubject(id);
    }
}
