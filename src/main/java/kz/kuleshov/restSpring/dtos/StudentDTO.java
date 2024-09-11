package kz.kuleshov.restSpring.dtos;

import kz.kuleshov.restSpring.entities.Subject;
import kz.kuleshov.restSpring.entities.University;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class StudentDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private int age;
    private double gpa;
    private University university;
    private List<Subject> subjects;


}
