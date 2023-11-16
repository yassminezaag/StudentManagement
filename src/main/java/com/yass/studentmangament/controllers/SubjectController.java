package com.yass.studentmangament.controllers;

import com.yass.studentmangament.entities.Subject;
import com.yass.studentmangament.services.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    ISubjectService subjectService;

    @PostMapping("/add")
    public Subject createSubject(@RequestBody Subject subject){
        return subjectService.createSubject(subject);
    }
    @GetMapping("/getall")
    public List<Subject> getAll(){
        return subjectService.getAllSubjects();
    }
}
