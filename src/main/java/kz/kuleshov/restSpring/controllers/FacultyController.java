package kz.kuleshov.restSpring.controllers;

import kz.kuleshov.restSpring.entities.Faculty;
import kz.kuleshov.restSpring.repositories.FacultyRepository;
import kz.kuleshov.restSpring.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;
    @GetMapping
    public List<Faculty> getAllFaculties(){
        return facultyService.getAllFaculties();
    }
    @PostMapping
    public Faculty addFaculty(@RequestBody Faculty faculty){
        return facultyService.addFaculty(faculty);
    }

}
