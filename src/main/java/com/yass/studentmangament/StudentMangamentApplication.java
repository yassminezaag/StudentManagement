package com.yass.studentmangament;

import com.yass.studentmangament.entities.*;
import com.yass.studentmangament.services.AddressService;
import com.yass.studentmangament.services.CourseService;
import com.yass.studentmangament.services.StudentService;
import com.yass.studentmangament.services.SubjectService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
@SpringBootApplication
public class StudentMangamentApplication implements CommandLineRunner {
    @Autowired
    StudentService studentService;
    @Autowired
    AddressService addressService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    CourseService courseService;

    public static void main(String[] args) {
        SpringApplication.run(StudentMangamentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student student1 = new Student();
        student1.setFirstName("Ahmed");
        student1.setLastName("Salem");
        student1.setAge(19);


        studentService.createStudent(student1);

        Student student2 = new Student();
        student2.setFirstName("Yassmine");
        student2.setLastName("Aziza");
        student2.setAge(21);


        studentService.createStudent(student2);

        Address address1 = new Address();
        address1.setCity("Tunis");
        address1.setAddress("Soussa");
        address1.setStreet("Rue des palimiers");

        address1.setStudent(student1);

        addressService.createAddress(address1);

        Address address2 = new Address();
        address2.setCity("Tunis");
        address2.setAddress("Monastir");
        address2.setStreet("Skanes");

        address2.setStudent(student2);

        addressService.createAddress(address2);

        Subject subject1 = new Subject();
        subject1.setSubjName("Subject A");

        subject1.setStudent(student1);
        student1.getSubjects().add(subject1);

        Subject subject2 = new Subject();
        subject2.setSubjName("Subject B");

        subject2.setStudent(student2);
        student2.getSubjects().add(subject2);

        subject1.setStudent(student2);
        student2.getSubjects().add(subject1);




        subjectService.createSubject(subject1);
        subjectService.createSubject(subject2);

        Course course1 = new Course();
        course1.setName("English Course");

        Course course2 = new Course();
        course2.setName("French Course");



        course1.getStudents().add(student1);
        course1.getStudents().add(student2);
        student1.getCourses().add(course1);
        student2.getCourses().add(course1);

        courseService.createCourse(course1);

        course2.getStudents().add(student2);
        student2.getCourses().add(course2);

        courseService.createCourse(course2);


        studentService.createStudent(student1);
        studentService.createStudent(student2);




        List<Student> students = studentService.getAllStudents();
        List<Course> courses = courseService.getAllCourses();
        List<Subject> subjects = subjectService.getAllSubjects();

        // Afficher les données
        //System.out.println("Students: " + students);
        //System.out.println("Courses: " + courses);
        //System.out.println("Subjects: " + subjects);

        for (Student student:students){
            System.out.println("Name : "+student.getFirstName()+" "+student.getLastName());
            System.out.println("Age : "+student.getAge());
            System.out.println("Address : "+student.getAddress());
        }
        System.out.println();
        System.out.println("Liste des cours :");
        for (Course course : courses) {
            System.out.println("Nom du cours : " + course.getName());
            System.out.println("Étudiants inscrits :");
            for (Student student : course.getStudents()) {
                System.out.println("- " + student.getFirstName() + " " + student.getLastName());
            }
            System.out.println();
        }


        System.out.println("Liste des matières :");
        for (Subject subject : subjects) {
            System.out.println("Nom de la matière : " + subject.getSubjName());
            System.out.println("Étudiant associé : " + subject.getStudent().getFirstName() + " " + subject.getStudent().getLastName());
            System.out.println();
        }





    }
}
