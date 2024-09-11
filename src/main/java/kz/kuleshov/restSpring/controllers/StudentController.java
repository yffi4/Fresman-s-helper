package kz.kuleshov.restSpring.controllers;

import kz.kuleshov.restSpring.dtos.StudentDTO;
import kz.kuleshov.restSpring.entities.Student;
import kz.kuleshov.restSpring.repositories.StudentRepository;
import kz.kuleshov.restSpring.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public List<StudentDTO> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public StudentDTO getStudent(@PathVariable("id") Long id){
        return studentService.getStudentById(id);
    }
    @PostMapping
    public void addStudent(@RequestBody StudentDTO student){
        studentService.addStudent(student);
    }
    @PutMapping
    public void updateStudent(@RequestBody StudentDTO updStudent){
        studentService.updateStudent(updStudent);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        studentService.delStudent(id);
    }
}
