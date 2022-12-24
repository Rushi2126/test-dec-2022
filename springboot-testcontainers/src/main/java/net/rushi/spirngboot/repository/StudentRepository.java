package net.rushi.spirngboot.repository;

import net.rushi.spirngboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
