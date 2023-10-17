package com.yass.studentmangament.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data

public class AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Ajoutez un getter pour l'attribut 'id'
    public Long getId() {
        return id;
    }

    // Ajoutez un setter pour l'attribut 'id' si nécessaire
    public void setId(Long id) {
        this.id = id;
    }

}
