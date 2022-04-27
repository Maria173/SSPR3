package ru.ulstu.is.sbapp.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ulstu.is.sbapp.university.service.SubjectService;

import javax.validation.Valid;

@Controller
@RequestMapping("/subject")
public class SubjectMvcController {
    private final SubjectService subjectService;

    public SubjectMvcController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public String getSubject(Model model) {
        model.addAttribute("subjects",
                subjectService.findAllSubjects().stream()
                        .map(SubjectDto::new)
                        .toList());
        return "subject";
    }

    @GetMapping(value = { "/edit", "/edit/{id}" })
    public String editSubject(@PathVariable(required = false) Long id, Model model) {
        if (id == null || id <= 0) {
            model.addAttribute("subjectDto", new SubjectDto());
        } else {
            model.addAttribute("subjectId", id);
            model.addAttribute("subjectDto", new SubjectDto(subjectService.findSubject(id)));
        }
        return "subject-edit";
    }

    @PostMapping(value = { "", "/{id}" })
    public String saveSubject(@PathVariable(required = false) Long id,
            @ModelAttribute @Valid SubjectDto subjectDto,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "subject-edit";
        }
        if (id == null || id <= 0) {
            subjectService.addSubject(subjectDto.getName(), subjectDto.getHours());
        } else {
            subjectService.updateSubject(id, subjectDto.getName(), subjectDto.getHours());
        }
        return "redirect:/subject";
    }

    @PostMapping("/delete/{id}")
    public String deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);
        return "redirect:/subject";
    }
}