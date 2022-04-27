package ru.ulstu.is.sbapp.university.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ulstu.is.sbapp.university.service.SubjectService;
import org.springframework.web.bind.annotation.RequestBody;
import ru.ulstu.is.sbapp.WebConfiguration;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping(WebConfiguration.REST_API + "/subjects")
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/{id}")
    public SubjectDto getSubject(@PathVariable Long id) {
        return new SubjectDto(subjectService.findSubject(id));
    }

    @GetMapping("/")
    public List<SubjectDto> getSubjects() {
        return subjectService.findAllSubjects().stream()
                .map(SubjectDto::new)
                .toList();
    }

    @PostMapping
    public SubjectDto createSubject(@RequestBody @Valid SubjectDto subjectDto) {
        return new SubjectDto(subjectService.addSubject(subjectDto.getName(), subjectDto.getHours()));
    }

    @PutMapping("/{id}")
    public SubjectDto updateSubject(@PathVariable Long id,
            @RequestBody @Valid SubjectDto subjectDto) {
        return new SubjectDto(subjectService.updateSubject(id, subjectDto.getName(), subjectDto.getHours()));
    }

    @DeleteMapping("/{id}")
    public SubjectDto deleteExpenses(@PathVariable Long id) {
        return new SubjectDto(subjectService.deleteSubject(id));
    }
}
