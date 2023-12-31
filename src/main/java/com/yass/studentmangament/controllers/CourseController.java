package com.yass.studentmangament.controllers;

import com.yass.studentmangament.entities.Course;
import com.yass.studentmangament.services.ICourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    ICourseService courseService;


    @PostMapping("/add")
    public void createCourse(@RequestBody @Valid Course course){
         courseService.createCourse(course);
    }
    @GetMapping("/getall")
    public List<Course> getAll(){
        return courseService.getAllCourses();
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id ){
        try {
            courseService.deleteCourseById(id);
            return "Course is deleted";
        } catch (Exception e){
            return "Erreur"+e.toString();
        }

    }
}
