package kz.kuleshov.restSpring.services.impl;

import kz.kuleshov.restSpring.entities.Subject;
import kz.kuleshov.restSpring.repositories.SubjectRepository;
import kz.kuleshov.restSpring.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject addSubject(Subject subject) {
        return subjectRepository.save(subject);
    }
}
