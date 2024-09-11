package kz.kuleshov.restSpring.services;


import kz.kuleshov.restSpring.entities.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getAllSubjects();
    Subject addSubject(Subject subject);


}
