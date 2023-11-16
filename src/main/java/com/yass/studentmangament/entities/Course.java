package com.yass.studentmangament.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course extends AuditModel{
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Student> students = new HashSet<Student>();

  /**  @Override
    public int hashCode() {
        return Objects.hash(getId(), name);
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                "} " ;
    }
    **/
}
