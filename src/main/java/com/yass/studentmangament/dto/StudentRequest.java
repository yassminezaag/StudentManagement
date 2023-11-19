package com.yass.studentmangament.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequest {
    private Long id;
    @NotNull(message = "Firstname must not be null !!")
    private String firstName;
    @NotNull(message = "Lastname must not be null !!")
    private String lastName;
    @NotNull(message = "Age must not be null!")
    private int age;
}
