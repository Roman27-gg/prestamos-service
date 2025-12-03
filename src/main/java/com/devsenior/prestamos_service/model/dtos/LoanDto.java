package com.devsenior.prestamos_service.model.dtos;

import java.time.LocalDate;

import com.devsenior.prestamos_service.model.enums.LoanStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Representacion de un prestamo")
public class LoanDto {
    @Schema(description = "Id relacionada con el prestamo", example = "2")
    private Long id;
    @Nonnull
    @Schema(description = "Id relacionada con el empleado que realizo el prestamo", example = "1")
    private Long employeeid;
    @Nonnull
    @Schema(description = "Id relacionada con el equipo tecnologico que esta implicado en el prestamo", example = "3")
    private long equipmentid;
    @PastOrPresent
    @Schema(description = "Fecha en la que ocurrio el prestamo", example = "2025-08-12")
    private LocalDate loandate;
    @FutureOrPresent
    @Schema(description = "Fecha en la que finalizo el prestamo", example = "2025-03-12")
    private LocalDate returndate;
    @Nonnull
    @Schema(description = "Estado actual del prestamo", example = "EN_CURSO")
    private LoanStatus state;
}