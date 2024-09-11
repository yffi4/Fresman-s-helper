package kz.kuleshov.restSpring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String surname;
    private int age;
    private double gpa;
    private String promocode;
    @ManyToOne(fetch = FetchType.EAGER)
    private University university;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Subject> subjects;
}
