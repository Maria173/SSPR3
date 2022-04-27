package ru.ulstu.is.sbapp.university.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ulstu.is.sbapp.university.service.TeacherService;
import org.springframework.web.bind.annotation.RequestBody;
import ru.ulstu.is.sbapp.WebConfiguration;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping(WebConfiguration.REST_API + "/teacher")
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

    @PostMapping
    public TeacherDto createTeacher(@RequestBody @Valid TeacherDto teacherDto) {
        return new TeacherDto(teacherService.addTeacher(teacherDto.getFirstName(), teacherDto.getLastName()));
    }

    @PutMapping("/{id}")
    public TeacherDto updateTeacher(@PathVariable Long id,
            @RequestBody @Valid TeacherDto teacherDto) {
        return new TeacherDto(teacherService.updateTeacher(id, teacherDto.getFirstName(), teacherDto.getLastName()));
    }

    @DeleteMapping("/{id}")
    public TeacherDto deleteTeacher(@PathVariable Long id) {
        return new TeacherDto(teacherService.deleteTeacher(id));
    }
}
