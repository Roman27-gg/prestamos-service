package com.devsenior.prestamos_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenior.prestamos_service.model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    
}
