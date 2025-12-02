package com.devsenior.prestamos_service.model.dtos;

import com.devsenior.prestamos_service.model.enums.EmployeeRole;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;
    @NotBlank
    @Size(max = 15, message = "El campo 'name' tiene que ser igual o menor a los 15 caracteres")
    private String name;
    @NotBlank
    @Size(max = 15, message = "El campo 'lastname' tiene que ser igual o menor a los 15 caracteres")
    private String lastname;
    @NotBlank
    @Size(max = 13, message = "El campo 'document' tiene que ser igual o menor a los 13 caracteres")
    private String document;
    @Nonnull
    private EmployeeRole role;
}
