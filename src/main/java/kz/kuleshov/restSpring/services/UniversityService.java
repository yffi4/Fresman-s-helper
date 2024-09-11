package kz.kuleshov.restSpring.services;

import kz.kuleshov.restSpring.entities.University;

import java.util.List;
import java.util.Optional;

public interface UniversityService {
    List<University> getAllUniversities();
    Optional<University> getUniversityById(Long id);
    University addUniversity(University university);
    University UpdateUniversity(University university);
    void delUniversity(Long id);

}
