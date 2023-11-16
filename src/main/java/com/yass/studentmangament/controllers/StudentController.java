package com.yass.studentmangament.controllers;

import com.yass.studentmangament.entities.Student;
import com.yass.studentmangament.services.IStudentService;
import com.yass.studentmangament.services.StudentService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
    @GetMapping("/getall")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/findbyname")
    public List<Student> getByName(@PathParam(value = "name")String name){
            return studentService.findByFirstName(name);
    }



}
