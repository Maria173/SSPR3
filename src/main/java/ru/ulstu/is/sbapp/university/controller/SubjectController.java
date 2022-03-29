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
@RequestMapping("/subject")
public class SubjectController {
    private final TeacherService teacherService;

    public SubjectController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/{id}")
    public SubjectDto getSubject(@PathVariable Long id) {
        return new SubjectDto(teacherService.findSubject(id));
    }

    @GetMapping("/")
    public List<SubjectDto> getSubjects() {
        return teacherService.findAllSubjects().stream()
                .map(SubjectDto::new)
                .toList();
    }

    @PostMapping("/")
    public SubjectDto createSubject(@RequestParam("name") String name,
            @RequestParam("hours") int hours,
            @RequestParam("teacherId") Long teacherId) {
        return new SubjectDto(teacherService.addSubject(name, hours, teacherId));
    }

    @PatchMapping("/{id}")
    public SubjectDto updateSubject(@PathVariable Long id,
            @RequestParam("name") String name,
            @RequestParam("hours") int hours,
            @RequestParam("teacherId") Long teacherId) {
        return new SubjectDto(teacherService.updateSubject(id, name, hours, teacherId));
    }

    @DeleteMapping("/{id}")
    public SubjectDto deleteSubject(@PathVariable Long id) {
        return new SubjectDto(teacherService.deleteSubject(id));
    }
}
