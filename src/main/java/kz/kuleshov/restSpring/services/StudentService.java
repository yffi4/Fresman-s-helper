package kz.kuleshov.restSpring.services;

import kz.kuleshov.restSpring.dtos.StudentDTO;
import kz.kuleshov.restSpring.entities.Student;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();
    StudentDTO getStudentById(Long id);
    void updateStudent(StudentDTO updStudent);
    void addStudent(StudentDTO student);
    void delStudent(Long id);

}
