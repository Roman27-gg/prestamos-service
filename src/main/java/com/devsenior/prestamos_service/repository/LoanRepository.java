package com.devsenior.prestamos_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.devsenior.prestamos_service.model.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {


    List<Loan> findByEmployeeId(Long id);

    List<Loan> findByEquipmentId(Long id);
    
}
