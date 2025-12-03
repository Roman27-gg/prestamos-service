package com.devsenior.prestamos_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.devsenior.prestamos_service.model.entity.TechnologicalEquipment;

@Repository
public interface TechnologicalEquipmentRepository extends JpaRepository<TechnologicalEquipment, Long> {

    @Query("""
            SELECT t
            FROM TechnologicalEquipment t
            WHERE LOWER(t.name)  LIKE LOWER(CONCAT('%', :text, '%'))
               OR LOWER(t.type)  LIKE LOWER(CONCAT('%', :text, '%'))
               OR LOWER(t.brand) LIKE LOWER(CONCAT('%', :text, '%'))
            """)
    List<TechnologicalEquipment> searchByText(@Param("text") String text);

}
