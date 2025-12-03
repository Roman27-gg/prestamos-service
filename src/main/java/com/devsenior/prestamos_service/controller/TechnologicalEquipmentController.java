package com.devsenior.prestamos_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.prestamos_service.model.dtos.TechnologicalEquipmentDto;
import com.devsenior.prestamos_service.service.interfaces.TechnologicalEquipmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/equipos")
@Tag(name = "Controlador de equipos tecnologicos", description = "Controlador para administrar equipos tecnologicos")
public class TechnologicalEquipmentController {
    private TechnologicalEquipmentService service;

    public TechnologicalEquipmentController(TechnologicalEquipmentService service){
        this.service=service;
    }
    
    @Operation(summary = "Obtener una lista con todos los equipos", description = "Se obtiene una lista con todos los equipos tecnologicos en la base datos, puede ser vacia")
    @ApiResponse(responseCode = "200", description = "Se obtiene una lista que puede contener o no equipos tecnoplogicos")
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<TechnologicalEquipmentDto> getAll() {
        return service.getAll();
    }

    
    @Operation(summary = "Obtener un equipo por su id", description = "Se obtiene un equipo tecnologico de la base de datos por medio de su id")
    @ApiResponse(responseCode = "200", description = "Se obtuvo un equipo tecnologico correctamente")
    @ApiResponse(responseCode = "500", description = "No se encontro ningun equipo tecnologico con esa id", content = @Content())
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public TechnologicalEquipmentDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @Operation(summary = "Obtener una lista de equipos por medio de un texto", description = "Se obtiene una lista de equipop tecnologicos de la base de datos por medio de un texto registrado por el usuario")
    @ApiResponse(responseCode = "200", description = "Se realizo la peticion correctamente, puede contener una lista vacia")
    @GetMapping(value = "/buscar", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<TechnologicalEquipmentDto> getByText(@RequestParam String text) {
        return service.searchByText(text);
    }

    @Operation(summary = "Crear un equipo", description = "Se crea un nuevo equipo tecnologico y se registra en la base de datos")
    @ApiResponse(responseCode = "200", description = "Se obtuvo una lista de prestamos correctamente")
    @ApiResponse(responseCode = "400", description = "Ha ocurrido un error con el prestamo enviado", content = @Content())
    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public TechnologicalEquipmentDto createEquipment(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos del Equipo tecnologico a crear", 
            required = true, content = @Content(schema = @Schema(implementation = TechnologicalEquipmentDto.class)))
            @RequestBody @Valid TechnologicalEquipmentDto equipment) {
        return service.createEquipment(equipment);
    }

    @Operation(summary = "Actualizar un equipo", description = "Se actualiza un equipo tecnologico registrado en la base de datos")
    @ApiResponse(responseCode = "200", description = "Se actualizo el equipo tecnologico correctamente")
    @ApiResponse(responseCode = "500", description = "No se encontro ningun equipo tecnologico con esa id", content = @Content())
    @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public TechnologicalEquipmentDto updateInformationOfEquipment(@PathVariable Long id, 
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos del nuevo Equipo tecnologico para actualizar", 
            required = true, content = @Content(schema = @Schema(implementation = TechnologicalEquipmentDto.class)))
            @RequestBody @Valid TechnologicalEquipmentDto equipment) {        
        return service.update(id, equipment);
    }

    @Operation(summary = "Borrar un equipo", description = "Se borra un equipo tecnologico registrado en la base de datos")
    @ApiResponse(responseCode = "200", description = "Se borro el equipo tecnologico correctamente")
    @ApiResponse(responseCode = "500", description = "No se encontro ningun equipo tecnologico con esa id", content = @Content())
    @DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public void deleteEquipment(@PathVariable Long id){
        service.delete(id);
    } 
}