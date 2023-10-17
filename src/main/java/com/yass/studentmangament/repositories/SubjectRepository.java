package com.yass.studentmangament.repositories;

import com.yass.studentmangament.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
