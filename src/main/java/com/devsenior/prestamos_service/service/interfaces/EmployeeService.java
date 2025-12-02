package com.devsenior.prestamos_service.service.interfaces;

import java.util.List;

import com.devsenior.prestamos_service.model.dtos.EmployeeDto;


public interface EmployeeService {

    List<EmployeeDto> getAll();

    EmployeeDto getById(Long id);

    EmployeeDto create(EmployeeDto employee);

    EmployeeDto update(Long id, EmployeeDto employee);

    void delete(Long id);

}
