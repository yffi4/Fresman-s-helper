package kz.kuleshov.restSpring.repositories;

import jakarta.transaction.Transactional;
import kz.kuleshov.restSpring.entities.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UniversityRepository extends JpaRepository<University, Long> {
    University findAllById(Long id);
}
