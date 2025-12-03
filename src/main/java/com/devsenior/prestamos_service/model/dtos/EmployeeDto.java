package com.devsenior.prestamos_service.model.dtos;

import com.devsenior.prestamos_service.model.enums.EmployeeRole;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Representacion de un empleado")
public class EmployeeDto {
    @Schema(description = "Id relacionada con el empleado", example = "1")
    private Long id;
    @NotBlank
    @Size(max = 15, message = "El campo 'name' tiene que ser igual o menor a los 15 caracteres")
    @Schema(description = "Nombre del empleado", example = "Homero")
    private String name;
    @NotBlank
    @Size(max = 15, message = "El campo 'lastname' tiene que ser igual o menor a los 15 caracteres")
    @Schema(description = "Apellido del empleado", example = "Griffin")
    private String lastname;
    @NotBlank
    @Size(max = 13, message = "El campo 'document' tiene que ser igual o menor a los 13 caracteres")
    @Schema(description = "Documento del empleado", example = "12369584")
    private String document;
    @Nonnull
    @Schema(description = "Role o cargo del empleado", example = "PRODUCCION")
    private EmployeeRole role;
}
