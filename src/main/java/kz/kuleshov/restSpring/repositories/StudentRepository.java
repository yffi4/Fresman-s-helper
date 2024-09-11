package kz.kuleshov.restSpring.repositories;

import jakarta.transaction.Transactional;
import kz.kuleshov.restSpring.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findAllById(Long id);

    Student findAllByEmail(String email);
}
