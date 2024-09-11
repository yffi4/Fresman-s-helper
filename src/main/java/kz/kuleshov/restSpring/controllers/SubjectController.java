package kz.kuleshov.restSpring.controllers;

import kz.kuleshov.restSpring.entities.Subject;
import kz.kuleshov.restSpring.repositories.SubjectRepository;
import kz.kuleshov.restSpring.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @GetMapping
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubjects();
    }
    @PostMapping
    public Subject addSubject(@RequestBody Subject subject){
        return subjectService.addSubject(subject);
    }

}
