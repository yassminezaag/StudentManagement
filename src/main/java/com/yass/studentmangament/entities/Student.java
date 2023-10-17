package com.yass.studentmangament.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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
public class Student extends AuditModel {

    private String firstName, lastName;
    private int age;

    @ManyToMany
    @JoinTable(name = "student_courses",
    joinColumns = @JoinColumn(name = "id_student", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "id_course", referencedColumnName = "id"))
    private Set<Course> courses = new HashSet<Course>();

    @OneToOne(mappedBy = "student")
    private Address address;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Subject> subjects = new ArrayList<>();


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
