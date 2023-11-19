package com.yass.studentmangament.services;

import com.yass.studentmangament.dto.StudentRequest;
import com.yass.studentmangament.dto.StudentResponse;
import com.yass.studentmangament.entities.Student;

import java.util.List;

public interface IStudentService {
    public void createStudent(StudentRequest student);
    public List<StudentResponse> getAllStudents();
    public void deleteStudentById(Long id);
    public List<Student> findByFirstName(String name);
    public StudentResponse findById(Long id);
}
