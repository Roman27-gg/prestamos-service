package com.devsenior.prestamos_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.prestamos_service.model.dtos.LoanDto;
import com.devsenior.prestamos_service.service.interfaces.LoanService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/prestamos")
@Tag(name = "Controlador de prestamos", description = "Controlador para administrar los prestamos de equipos tecnologicos")
public class LoanController {
    private LoanService service;

    public LoanController(LoanService service) {
        this.service = service;
    }

    @Operation(summary = "Obtener una lista con todos los prestamos", description = "Se obtiene una lista con todos los prestamos en la base datos, puede ser vacia")
    @ApiResponse(responseCode = "200", description = "Se obtiene una lista que puede contener o no prestamos")
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<LoanDto> getAll() {
        return service.getAll();
    }

    @Operation(summary = "Obtener un prestamo por su id", description = "Se obtiene un prestamo de la base de datos por medio de su id")
    @ApiResponse(responseCode = "200", description = "Se obtuvo un prestamo correctamente")
    @ApiResponse(responseCode = "500", description = "No se encontro ningun prestamo con esa id", content = @Content())
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public LoanDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @Operation(summary = "Obtener una lista de prestamos por empleado", description = "Se obtiene una lista de prestamos segun un empleado especifico")
    @ApiResponse(responseCode = "200", description = "Se obtuvo una lista de prestamos correctamente")
    @ApiResponse(responseCode = "500", description = "No se encontro ningun empleado con esa id", content = @Content())
    @GetMapping(value = "/empleado/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<LoanDto> getByEmployee(@PathVariable Long id) {
        return service.getByEmployee(id);
    }

    @Operation(summary = "Obtener una lista de prestamos por equipo", description = "Se obtiene una lista de prestamos segun un equipo especifico")
    @ApiResponse(responseCode = "200", description = "Se obtuvo una lista de prestamos correctamente")
    @ApiResponse(responseCode = "500", description = "No se encontro ningun equipo con esa id", content = @Content())
    @GetMapping(value = "/equipo/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<LoanDto> getByEquipment(@PathVariable Long id) {
        return service.getByEquipment(id);
    }

    @Operation(summary = "Crear un prestamo", description = "Se crea un nuevo prestamo, se registra en la base de datos y se cambia el 'state' del equipo a 'PRESTADO'")
    @ApiResponse(responseCode = "200", description = "Se creo el prestamo correctamente")
    @ApiResponse(responseCode = "400", description = "Ha ocurrido un error con el prestamo enviado", content = @Content())
    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public LoanDto create(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos del prestamo a crear", 
            required = true, content = @Content(schema = @Schema(implementation = LoanDto.class)))
            @RequestBody @Valid LoanDto entity) {
        return service.create(entity);
    }

    @Operation(summary = "Finalizar prestamo", description = "Se finaliza el prestamo del equipo, cambia su 'returndate' a la fecha actual, su 'state' a 'TERMINADO' y el 'state' del equipo a 'DISPONIBLE'")
    @ApiResponse(responseCode = "200", description = "Se finalizo el prestamo correctamente")
    @ApiResponse(responseCode = "500", description = "No se encontro ningun equipo con esa id", content = @Content())
    @PatchMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public LoanDto finalizeLoan(@PathVariable Long id) {
        return service.finalizeLoan(id);
    }
}