package com.devsenior.prestamos_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsenior.prestamos_service.model.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    
}
