package com.devsenior.prestamos_service.service.impl;

import java.time.LocalDate;
import java.util.List;


import org.springframework.stereotype.Service;

import com.devsenior.prestamos_service.model.dtos.LoanDto;
import com.devsenior.prestamos_service.model.entity.Employee;
import com.devsenior.prestamos_service.model.entity.Loan;
import com.devsenior.prestamos_service.model.entity.TechnologicalEquipment;
import com.devsenior.prestamos_service.model.enums.EquipmentState;
import com.devsenior.prestamos_service.model.enums.LoanStatus;
import com.devsenior.prestamos_service.repository.EmployeeRepository;
import com.devsenior.prestamos_service.repository.LoanRepository;
import com.devsenior.prestamos_service.repository.TechnologicalEquipmentRepository;
import com.devsenior.prestamos_service.service.interfaces.LoanService;

@Service
public class LoanServiceImpl implements LoanService {
    private LoanRepository loanrepository;
    private EmployeeRepository employeerepository;
    private TechnologicalEquipmentRepository equipmentrepository;

    public LoanServiceImpl(LoanRepository loanrepository, EmployeeRepository employeerepository,
            TechnologicalEquipmentRepository equipmentrepository) {
        this.loanrepository = loanrepository;
        this.employeerepository = employeerepository;
        this.equipmentrepository = equipmentrepository;
    }

    @Override
    public List<LoanDto> getAll() {
        return loanrepository.findAll().stream().map(this::entityToDto).toList();
    }

    @Override
    public LoanDto getById(Long id) {
        var entity = findEntity(id);
        var dto = entityToDto(entity);
        return dto;
    }

    @Override
    public List<LoanDto> getByEmployee(Long id) {
        return loanrepository.findByEmployeeId(id).stream().map(this::entityToDto).toList();
    }

    @Override
    public List<LoanDto> getByEquipment(Long id) {
        return loanrepository.findByEquipmentId(id).stream().map(this::entityToDto).toList();
    }

    @Override
    public LoanDto create(LoanDto dto) {
        var entity = dtoToEntity(dto);
        var equipment = entity.getEquipment();
        if (!equipment.getState().equals(EquipmentState.DISPONIBLE)) {
            throw new IllegalStateException("El equipo no esta en condiciones de ser prestado");
        }
        equipment.setState(EquipmentState.PRESTADO);
        equipmentrepository.save(equipment);
        if (entity.getLoandate() == null) entity.setLoandate(LocalDate.now());
        loanrepository.save(entity);
        return entityToDto(entity);
    }

    @Override
    public LoanDto finalizeLoan(Long id) {
        var entity = findEntity(id);
        entity.setReturndate(LocalDate.now());
        entity.setState(LoanStatus.TERMINADO);
        var equipment = entity.getEquipment();
        if (!equipment.getState().equals(EquipmentState.PRESTADO)) throw new IllegalStateException("El equipo no esta en prestamo actualmente");
        equipment.setState(EquipmentState.DISPONIBLE);
        equipmentrepository.save(equipment);
        loanrepository.save(entity);
        return entityToDto(entity);
    }

    // private methods
    private LoanDto entityToDto(Loan loan) {
        LoanDto dto = new LoanDto();
        Employee employee = loan.getEmployee();
        TechnologicalEquipment equipment = loan.getEquipment();
        dto.setEmployeeid(employee.getId());
        dto.setEquipmentid(equipment.getId());
        dto.setId(loan.getId());
        dto.setLoandate(loan.getLoandate());
        dto.setReturndate(loan.getReturndate());
        dto.setState(loan.getState());
        return dto;
    }

    private Loan dtoToEntity(LoanDto dto) {
        Loan loan = new Loan();
        Employee employee = findEmployee(dto.getEmployeeid());
        TechnologicalEquipment equipment = findEquipment(dto.getEquipmentid()); 
        loan.setEmployee(employee);
        loan.setEquipment(equipment);
        loan.setId(dto.getId());
        loan.setLoandate(dto.getLoandate());
        loan.setReturndate(dto.getReturndate());
        loan.setState(dto.getState());
        return loan;
    }

    private Loan findEntity(Long id) {
        return loanrepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("El id registrado no esta relacionado con ningun prestamo"));
    }

    private Employee findEmployee(Long id){
        return employeerepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El id registrado no esta relacionado con ningun eempleado"));
    }

    private TechnologicalEquipment findEquipment(Long id){
        return equipmentrepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El id registrado no esta relacionado con ningun equipo tecnologico")); 
    }
}