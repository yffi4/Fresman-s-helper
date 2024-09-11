package kz.kuleshov.restSpring.repositories;

import jakarta.transaction.Transactional;
import kz.kuleshov.restSpring.entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
