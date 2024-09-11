package kz.kuleshov.restSpring.controllers;

import kz.kuleshov.restSpring.entities.University;
import kz.kuleshov.restSpring.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/university")
public class UniversityController {
    @Autowired
    private UniversityService universityService;
    @GetMapping
    public List<University> getAllUniversity(){
        return universityService.getAllUniversities();
    }
    @GetMapping("/{id}")
    public Optional<University> getUniversity(@PathVariable("id") Long id){
        return universityService.getUniversityById(id);
    }
    @PostMapping
    public University addUser(@RequestBody University university){
        return universityService.addUniversity(university);
    }
    @PutMapping
    public University updateUniversity(@RequestBody University university){
        return universityService.UpdateUniversity(university);
    }
    @DeleteMapping("/{id}")
    public void deleteUniversity(@PathVariable("id") Long id){
        universityService.delUniversity(id);
    }
}
