package com.devsenior.prestamos_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.prestamos_service.model.dtos.TechnologicalEquipmentDto;
import com.devsenior.prestamos_service.service.interfaces.TechnologicalEquipmentService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/equipos")
public class TechnologicalEquipmentController {
    private TechnologicalEquipmentService service;

    public TechnologicalEquipmentController(TechnologicalEquipmentService service){
        this.service=service;
    }

    @GetMapping()
    public List<TechnologicalEquipmentDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TechnologicalEquipmentDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/buscar")
    public List<TechnologicalEquipmentDto> getByText(@RequestParam String text) {
        return service.searchByText(text);
    }

    @PostMapping()
    public TechnologicalEquipmentDto createEquipment(@RequestBody @Valid TechnologicalEquipmentDto equipment) {
        return service.createEquipment(equipment);
    }

    @PutMapping("/{id}")
    public TechnologicalEquipmentDto updateInformationOfEquipment(@PathVariable Long id, @RequestBody @Valid TechnologicalEquipmentDto equipment) {        
        return service.update(id, equipment);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipment(@PathVariable Long id){
        service.delete(id);
    } 
}