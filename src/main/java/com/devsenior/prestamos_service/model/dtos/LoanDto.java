package com.devsenior.prestamos_service.model.dtos;

import java.time.LocalDate;

import com.devsenior.prestamos_service.model.enums.LoanStatus;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanDto {
    private Long id;
    @Nonnull
    private Long employeeid;
    @Nonnull
    private long equipmentid;
    @PastOrPresent
    private LocalDate loandate;
    @FutureOrPresent
    private LocalDate returndate;
    @Nonnull
    private LoanStatus state;
}