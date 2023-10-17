package com.yass.studentmangament.services;

import com.yass.studentmangament.entities.Student;

import java.util.List;

public interface IStudentService {
    public Student createStudent(Student student);
    public List<Student> getAllStudents();
    public void deleteStudentById(Long id);
}
