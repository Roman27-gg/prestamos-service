package com.devsenior.prestamos_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.prestamos_service.model.dtos.EmployeeDto;
import com.devsenior.prestamos_service.service.interfaces.EmployeeService;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/empleados")
@Tag(name = "Controlador de empleados", description = "Controlador para administrar empleados")
public class EmployeeController {

    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @Operation(summary = "Obtener una lista con todos los empleados", description = "Se obtiene una lista con todos los empleados en la base datos, puede ser vacia")
    @ApiResponse(responseCode = "200", description = "Se obtiene una lista que puede contener o no empleados")
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<EmployeeDto> getAll() {
        return service.getAll();
    }

    @Operation(summary = "Obtener un empleado por su id", description = "Se busca en la base de datos un empleado el cual concuerde su id")
    @ApiResponse(responseCode = "200", description = "Se obtiene un empleado de la lista")
    @ApiResponse(responseCode = "500", description = "No se encontro ningun empleado con esa id", content = @Content())
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public EmployeeDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @Operation(summary = "Crear un empleado", description = "Crea un empleado, lo guarda en la base de datos y retorna este mismo empleado")
    @ApiResponse(responseCode = "200", description = "Se ha creado el empleado correctamente")
    @ApiResponse(responseCode = "400", description = "Ha ocurrido un error con el empleado enviado", content = @Content())
    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public EmployeeDto create(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos del Empleado a crear", 
            required = true, content = @Content(schema = @Schema(implementation = EmployeeDto.class))) 
            @RequestBody @Valid EmployeeDto employee) {
        return service.create(employee);
    }

    @Operation(summary = "Actualizar un empleado", description = "Actualiza un empleado, lo busca en la base de datos atraves de la id y si lo encuentra lo actualiza")
    @ApiResponse(responseCode = "200", description = "Se ha actualizado el empleado correctamente")
    @ApiResponse(responseCode = "400", description = "Ha ocurrido un error con el empleado enviado", content = @Content())
    @ApiResponse(responseCode = "500", description = "No se encontro ningun empleado con esa id", content = @Content())
    @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public EmployeeDto update(@PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos del Empleado a actualizar", 
            required = true, content = @Content(schema = @Schema(implementation = EmployeeDto.class))) 
            @RequestBody @Valid EmployeeDto employee) {
        return service.update(id, employee);
    }

    @Operation(summary = "Borrar un empleado", description = "Borra un empleado de la base de datos por medio de su id")
    @ApiResponse(responseCode = "200", description = "Se ha borrado el empleado correctamente")
    @ApiResponse(responseCode = "500", description = "No se encontro ningun empleado con esa id", content = @Content())
    @DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}