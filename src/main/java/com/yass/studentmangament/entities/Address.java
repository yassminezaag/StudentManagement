package com.yass.studentmangament.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address extends AuditModel{
    private String address;
    private String city;
    private String street;

    @OneToOne
    @JoinColumn(name = "id_student", referencedColumnName = "id")
    @JsonBackReference
    private Student student;

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                "} ";
    }
}
