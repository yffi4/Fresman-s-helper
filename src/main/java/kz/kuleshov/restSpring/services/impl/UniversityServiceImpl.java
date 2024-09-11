package kz.kuleshov.restSpring.services.impl;

import kz.kuleshov.restSpring.entities.University;
import kz.kuleshov.restSpring.repositories.UniversityRepository;
import kz.kuleshov.restSpring.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityServiceImpl implements UniversityService {
    @Autowired
    private UniversityRepository universityRepository;
    @Override
    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }

    @Override
    public Optional<University> getUniversityById(Long id) {
        return universityRepository.findById(id);
    }

    @Override
    public University addUniversity(University university) {
        return universityRepository.save(university);
    }

    @Override
    public University UpdateUniversity(University university) {
        return universityRepository.save(university);
    }

    @Override
    public void delUniversity(Long id) {
        universityRepository.deleteById(id);
    }
}
