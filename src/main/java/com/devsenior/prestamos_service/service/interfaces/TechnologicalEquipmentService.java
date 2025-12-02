package com.devsenior.prestamos_service.service.interfaces;

import java.util.List;



import com.devsenior.prestamos_service.model.dtos.TechnologicalEquipmentDto;


public interface TechnologicalEquipmentService {

    List<TechnologicalEquipmentDto> getAll();

    TechnologicalEquipmentDto getById(Long id);

    List<TechnologicalEquipmentDto> searchByText(String text);

    TechnologicalEquipmentDto createEquipment(TechnologicalEquipmentDto equipment);

    TechnologicalEquipmentDto update(Long id, TechnologicalEquipmentDto equipment);

    void delete(Long id);

}
