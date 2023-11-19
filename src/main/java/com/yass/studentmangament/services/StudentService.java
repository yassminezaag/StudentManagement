package com.yass.studentmangament.services;


import com.yass.studentmangament.dto.StudentRequest;
import com.yass.studentmangament.dto.StudentResponse;
import com.yass.studentmangament.entities.Student;
import com.yass.studentmangament.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public void createStudent(StudentRequest student) {
        Student s = studentMapper.toStudent(student);
        studentRepository.save(s);
    }


    @Override
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toStudentDto)
                .collect(Collectors.toList());
    }



    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);

    }

    @Override
    public List<Student> findByFirstName(String name) {
        return studentRepository.findByFirstNameLike(name);
    }

    @Override
    public StudentResponse findById(Long id) {
        return this.studentRepository.findById(id)
                .map(studentMapper::toStudentDto)
                .orElse(new StudentResponse());

        }


}
