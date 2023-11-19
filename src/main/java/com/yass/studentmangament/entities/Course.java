package com.yass.studentmangament.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties("students")
public class Course extends AuditModel{
    @NotNull(message = "course-name must not be null")
    private String name;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER)
   // @JsonBackReference
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
