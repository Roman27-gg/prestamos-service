package com.devsenior.prestamos_service.service.impl;

import java.util.List;


import org.springframework.stereotype.Service;

import com.devsenior.prestamos_service.model.dtos.TechnologicalEquipmentDto;
import com.devsenior.prestamos_service.model.entity.TechnologicalEquipment;
import com.devsenior.prestamos_service.repository.TechnologicalEquipmentRepository;
import com.devsenior.prestamos_service.service.interfaces.TechnologicalEquipmentService;

@Service
public class TechnologicalEquipmentServiceImpl implements TechnologicalEquipmentService {
    private TechnologicalEquipmentRepository repository;

    public TechnologicalEquipmentServiceImpl(TechnologicalEquipmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TechnologicalEquipmentDto> getAll() {
        return repository.findAll().stream().map(this::entityToDto).toList();
    }

    @Override
    public TechnologicalEquipmentDto getById(Long id) {
        TechnologicalEquipment equipment = findEntity(id);
        var dto = entityToDto(equipment);
        return dto;
    }

    
    @Override
    public List<TechnologicalEquipmentDto> searchByText(String text) {
        return repository.searchByText(text).stream().map(this::entityToDto).toList();
    }

    @Override
    public TechnologicalEquipmentDto createEquipment(TechnologicalEquipmentDto equipment) {
        var entity = dtoToEntity(equipment);
        repository.save(entity);
        var dto = entityToDto(entity);
        return dto;
    }

    @Override
    public TechnologicalEquipmentDto update(Long id, TechnologicalEquipmentDto equipment) {
        TechnologicalEquipment entity = findEntity(id);
        entity.setId(equipment.getId());
        entity.setBrand(equipment.getBrand());
        entity.setModel(equipment.getModel());
        entity.setName(equipment.getName());
        entity.setSerial(equipment.getSerial());
        entity.setState(equipment.getState());
        entity.setType(equipment.getType());
        repository.save(entity);
        return entityToDto(entity);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    // private methods
    private TechnologicalEquipmentDto entityToDto(TechnologicalEquipment equipment) {
        TechnologicalEquipmentDto dto = new TechnologicalEquipmentDto();
        dto.setId(equipment.getId());
        dto.setBrand(equipment.getBrand());
        dto.setModel(equipment.getModel());
        dto.setName(equipment.getName());
        dto.setSerial(equipment.getSerial());
        dto.setState(equipment.getState());
        dto.setType(equipment.getType());
        return dto;
    }

    private TechnologicalEquipment dtoToEntity(TechnologicalEquipmentDto dto) {
        TechnologicalEquipment equipment = new TechnologicalEquipment();
        equipment.setId(dto.getId());
        equipment.setBrand(dto.getBrand());
        equipment.setModel(dto.getModel());
        equipment.setName(dto.getName());
        equipment.setSerial(dto.getSerial());
        equipment.setState(dto.getState());
        equipment.setType(dto.getType());
        return equipment;
    }

    private TechnologicalEquipment findEntity(Long id){
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException(
                "El id registrado no esta relacionado con ningun equipo tecnologico"));
    }

}