package com.yass.studentmangament.repositories;

import com.yass.studentmangament.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstNameAndAge(String name, int age);
    List<Student> findByFirstNameLike(String name);

}
