package com.devsenior.prestamos_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.prestamos_service.model.dtos.LoanDto;
import com.devsenior.prestamos_service.service.interfaces.LoanService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/prestamos")
public class LoanController {
    private LoanService service; 

    public LoanController(LoanService service){
        this.service=service;
    }

    @GetMapping()
    public List<LoanDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public LoanDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/empleado/{id}")
    public List<LoanDto> getByEmployee(@PathVariable Long id) {
        return service.getByEmployee(id);
    }

    @GetMapping("/equipo/{id}")
    public List<LoanDto> getByEquipment(@PathVariable Long id) {
        return service.getByEquipment(id);
    }

    @PostMapping()
    public LoanDto create(@RequestBody @Valid LoanDto entity) {
        return service.create(entity);
    }

    @PatchMapping("/{id}")
    public LoanDto finalizeLoan(@PathVariable Long id){
        return service.finalizeLoan(id);
    }
}