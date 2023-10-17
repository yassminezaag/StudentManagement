package com.yass.studentmangament.repositories;

import com.yass.studentmangament.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
