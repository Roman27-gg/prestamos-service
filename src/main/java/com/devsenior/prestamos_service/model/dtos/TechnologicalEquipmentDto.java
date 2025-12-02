package com.devsenior.prestamos_service.model.dtos;


import com.devsenior.prestamos_service.model.enums.EquipmentState;
import com.devsenior.prestamos_service.model.enums.EquipmentType;


import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TechnologicalEquipmentDto {
    private Long id;
    @NotBlank
    @Size(max = 15, message = "El campo 'name' tiene que ser igual o menor a los 15 caracteres")
    private String name;
    @Nonnull
    private EquipmentType type;
    @NotBlank
    @Size(max = 12, message = "El campo 'brand' tiene que ser igual o menor a los 12 caracteres")
    private String brand;
    @NotBlank
    @Size(max = 12, min = 4, message = "El campo 'model' tiene que ser igual o menor a los 12 caracteres y mayor o igual a los 4 caracteres")
    private String model;
    @NotBlank
    @Size(max = 12, min = 5, message = "El campo 'serial' tiene que ser igual o menor a los 12 caracteres y mayor o igual a los 5 caracteres")
    private String serial;
    @Nonnull
    private EquipmentState state;
}