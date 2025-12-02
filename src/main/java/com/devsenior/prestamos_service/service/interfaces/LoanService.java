package com.devsenior.prestamos_service.service.interfaces;

import java.util.List;

import com.devsenior.prestamos_service.model.dtos.LoanDto;

public interface LoanService {

    List<LoanDto> getAll();

    LoanDto getById(Long id);

    List<LoanDto> getByEmployee(Long id);

    List<LoanDto> getByEquipment(Long id);

    LoanDto create(LoanDto dto);

    LoanDto finalizeLoan(Long id);

}
