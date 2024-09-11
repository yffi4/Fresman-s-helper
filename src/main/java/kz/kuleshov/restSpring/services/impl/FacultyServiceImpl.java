package kz.kuleshov.restSpring.services.impl;

import kz.kuleshov.restSpring.entities.Faculty;
import kz.kuleshov.restSpring.repositories.FacultyRepository;
import kz.kuleshov.restSpring.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }
}
