package com.devsenior.prestamos_service.model.entity;

import com.devsenior.prestamos_service.model.enums.EmployeeRole;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    private Long id;
    @Column(length = 15, nullable = false)
    private String name;
    @Column(name = "last_name",length = 15, nullable = false)
    private String lastname;
    @Column(length = 13, nullable = false)
    private String document;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmployeeRole role;
}