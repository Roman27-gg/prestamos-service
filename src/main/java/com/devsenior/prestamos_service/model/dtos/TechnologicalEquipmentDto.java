package com.devsenior.prestamos_service.model.dtos;


import com.devsenior.prestamos_service.model.enums.EquipmentState;
import com.devsenior.prestamos_service.model.enums.EquipmentType;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Representacion de un equipo tecnologico")
public class TechnologicalEquipmentDto {
    @Schema(description = "Id relacionada con el equipo", example = "3")
    private Long id;
    @NotBlank
    @Size(max = 15, message = "El campo 'name' tiene que ser igual o menor a los 15 caracteres")
    @Schema(description = "Nombre del equipo tecnologico", example = "Proyector 4k")
    private String name;
    @Nonnull
    @Schema(description = "Tipo al que pertenece el equipo tecnologico", example = "PROYECTOR")
    private EquipmentType type;
    @NotBlank
    @Size(max = 12, message = "El campo 'brand' tiene que ser igual o menor a los 12 caracteres")
    @Schema(description = "Marca a la que pertenece el equipo", example = "Lenovo")
    private String brand;
    @NotBlank
    @Size(max = 12, min = 4, message = "El campo 'model' tiene que ser igual o menor a los 12 caracteres y mayor o igual a los 4 caracteres")
    @Schema(description = "Referencia a la cual pertenece el equipo tecnologico", example = "Para cine, Laser")
    private String model;
    @NotBlank
    @Size(max = 12, min = 5, message = "El campo 'serial' tiene que ser igual o menor a los 12 caracteres y mayor o igual a los 5 caracteres")
    @Schema(description = "Serial unico de cada equipo", example = "PRO-599")
    private String serial;
    @Nonnull
    @Schema(description = "Estado actual del equipo", example = "PRESTADO")
    private EquipmentState state;
}