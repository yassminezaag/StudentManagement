package com.yass.studentmangament.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties("courses")
public class Student extends AuditModel {

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private int age;

    @ManyToMany
    @JoinTable(name = "student_courses",
    joinColumns = @JoinColumn(name = "id_student", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "id_course", referencedColumnName = "id"))
   // @JsonManagedReference
    private Set<Course> courses = new HashSet<Course>();

    @OneToOne(mappedBy = "student")
    @JsonManagedReference
    private Address address;




    @Override
    public int hashCode() {
        return Objects.hash(getId(), firstName, lastName, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                "} ";
    }
}
