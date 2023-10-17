package com.yass.studentmangament.services;

import com.yass.studentmangament.entities.Course;
import com.yass.studentmangament.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);

    }
}
