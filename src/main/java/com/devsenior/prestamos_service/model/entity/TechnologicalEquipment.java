package com.devsenior.prestamos_service.model.entity;

import com.devsenior.prestamos_service.model.enums.EquipmentState;
import com.devsenior.prestamos_service.model.enums.EquipmentType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Technological_Equipment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologicalEquipment {
    @Id
    private Long id;
    @Column(length = 15, nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EquipmentType type;
    @Column(length = 12, nullable = false)
    private String brand;
    @Column(length = 12, nullable = false)
    private String model;
    @Column(length = 12, nullable = false)
    private String serial;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EquipmentState state;
}