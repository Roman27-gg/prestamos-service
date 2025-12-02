package com.devsenior.prestamos_service.model.entity;

import java.time.LocalDate;

import com.devsenior.prestamos_service.model.enums.LoanStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "loan")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "employeeid", nullable = false)
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "equipmentid", nullable = false)
    private TechnologicalEquipment equipment;
    @Column(nullable = false)
    private LocalDate loandate;
    private LocalDate returndate;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LoanStatus state;
}