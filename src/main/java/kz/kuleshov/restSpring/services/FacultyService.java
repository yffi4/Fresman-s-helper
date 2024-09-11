package kz.kuleshov.restSpring.services;

import kz.kuleshov.restSpring.entities.Faculty;

import java.util.List;

public interface FacultyService {
    List<Faculty> getAllFaculties();
    Faculty addFaculty(Faculty faculty);
}
