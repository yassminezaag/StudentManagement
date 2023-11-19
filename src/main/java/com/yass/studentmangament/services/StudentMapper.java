package com.yass.studentmangament.services;

import com.yass.studentmangament.dto.StudentRequest;
import com.yass.studentmangament.dto.StudentResponse;
import com.yass.studentmangament.entities.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toStudent(StudentRequest student) {
        Student s =new Student();
        s.setId(student.getId());
        s.setFirstName(student.getFirstName());
        s.setLastName(student.getLastName());
        s.setAge(student.getAge());
        return s;
    }

    public StudentResponse toStudentDto(Student student) {
        var dto = StudentResponse.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .age(student.getAge())
                .nbrCourses(student.getCourses().size())
                .build();
        return dto;
    }

}
