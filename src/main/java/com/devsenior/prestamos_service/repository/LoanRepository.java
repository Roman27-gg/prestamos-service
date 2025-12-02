package com.devsenior.prestamos_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devsenior.prestamos_service.model.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query(value = """
            SELECT *
            from loan where employeeid = id
            """, nativeQuery = true)
    List<Loan> findLoanByEmployee(@Param("id") Long id);

    @Query(value = """
            SELECT *
            FROM loan WHERE equipmentid = id
            """, nativeQuery = true)
    List<Loan> findLoanByEquipment(@Param("id") Long id);
    
}
