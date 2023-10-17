package com.yass.studentmangament.services;

import com.yass.studentmangament.entities.Course;

import java.util.List;

public interface ICourseService {
    public Course createCourse(Course course);
    public List<Course> getAllCourses();
    public void deleteCourseById(Long id);
}
