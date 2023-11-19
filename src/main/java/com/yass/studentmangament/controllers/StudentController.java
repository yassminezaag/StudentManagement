package com.yass.studentmangament.controllers;


import com.yass.studentmangament.dto.StudentRequest;
import com.yass.studentmangament.dto.StudentResponse;
import com.yass.studentmangament.entities.Student;
import com.yass.studentmangament.services.IStudentService;
import com.yass.studentmangament.services.StudentService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @PostMapping("/add")
    public void addStudent(@RequestBody @Valid StudentRequest student){

         studentService.createStudent(student);

    }

    @GetMapping("/getall")
    public List<StudentResponse> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/findbyname")
    public List<Student> getByName(@PathParam(value = "name")String name){
            return studentService.findByFirstName(name);
    }
    @GetMapping("/findby/{id}")
    public StudentResponse findById(@PathVariable Long id){
        return studentService.findById(id);
    }



}
