package com.devsenior.prestamos_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.devsenior.prestamos_service.model.entity.TechnologicalEquipment;

public interface TechnologicalEquipmentRepository extends JpaRepository<TechnologicalEquipment, Long> {

    @Query(value = """
            SELECT *
            FROM technological_equipment
            WHERE LOWER(name)  LIKE CONCAT('%', LOWER(:text), '%')
               OR LOWER(type)  LIKE CONCAT('%', LOWER(:text), '%')
               OR LOWER(brand) LIKE CONCAT('%', LOWER(:text), '%')
            """, nativeQuery = true)
    List<TechnologicalEquipment> searchByText(@Param("text") String text);

}
