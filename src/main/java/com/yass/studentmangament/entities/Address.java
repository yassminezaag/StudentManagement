package com.yass.studentmangament.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address extends AuditModel{
    @NotNull(message = "must not be null !")
    private String address;
    @NotNull(message = "must not be null !")
    private String city;
    @NotNull(message = "must not be null !")
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
