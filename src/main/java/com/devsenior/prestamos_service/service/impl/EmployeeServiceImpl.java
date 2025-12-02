package com.devsenior.prestamos_service.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.prestamos_service.model.dtos.EmployeeDto;
import com.devsenior.prestamos_service.model.entity.Employee;
import com.devsenior.prestamos_service.repository.EmployeeRepository;
import com.devsenior.prestamos_service.service.interfaces.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EmployeeDto> getAll() {
        return repository.findAll().stream().map(this::entityToDto).toList();
    }

    @Override
    public EmployeeDto getById(Long id) {
        var entity = findEntity(id);
        var dto = entityToDto(entity);
        return dto;
    }

    @Override
    public EmployeeDto create(EmployeeDto employee) {
        var entity = dtoToEntity(employee);
        repository.save(entity);
        var dto = entityToDto(entity);
        return dto;
    }

    @Override
    public EmployeeDto update(Long id, EmployeeDto employee) {
        var entity = findEntity(id);
        entity.setDocument(employee.getDocument());
        entity.setId(employee.getId());
        entity.setLastname(employee.getLastname());
        entity.setName(employee.getName());
        entity.setRole(employee.getRole());
        repository.save(entity);
        return entityToDto(entity);
    }

    @Override
    public void delete(Long id) {
        var entity = findEntity(id);
        repository.delete(entity);
    }

    // private methods
    private EmployeeDto entityToDto(Employee employee) {
        EmployeeDto dto = new EmployeeDto();
        dto.setDocument(employee.getDocument());
        dto.setId(employee.getId());
        dto.setLastname(employee.getLastname());
        dto.setName(employee.getName());
        dto.setRole(employee.getRole());
        return dto;
    }

    private Employee dtoToEntity(EmployeeDto dto) {
        Employee entity = new Employee();
        entity.setDocument(dto.getDocument());
        entity.setId(dto.getId());
        entity.setLastname(dto.getLastname());
        entity.setName(dto.getName());
        entity.setRole(dto.getRole());
        return entity;
    }

    private Employee findEntity(Long id){
        return repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("El id registrado no esta relacionado con ningun empleado"));
    }
}