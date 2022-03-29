package ru.ulstu.is.sbapp.university.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    public TeacherDto getTeacher(@PathVariable Long id) {
        return new TeacherDto(teacherService.findTeacher(id));
    }

    @GetMapping("/")
    public List<TeacherDto> getTeachers() {
        return teacherService.findAllTeachers().stream()
                .map(TeacherDto::new)
                .toList();
    }

    @PostMapping("/")
    public TeacherDto createTeacher(@RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("experience") int experience) {
        return new TeacherDto(teacherService.addTeacher(firstName, lastName, experience));
    }

    @PatchMapping("/{id}")
    public TeacherDto updateTeacher(@PathVariable Long id,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("experience") int experience) {
        return new TeacherDto(teacherService.updateTeacher(id, firstName, lastName, experience));
    }

    @DeleteMapping("/{id}")
    public TeacherDto deleteTeacher(@PathVariable Long id) {
        return new TeacherDto(teacherService.deleteTeacher(id));
    }
}
