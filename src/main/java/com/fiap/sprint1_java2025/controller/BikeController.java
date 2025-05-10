package com.fiap.sprint1_java2025.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fiap.sprint1_java2025.model.Bike;
import com.fiap.sprint1_java2025.repository.BikeRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("bike")
public class BikeController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private BikeRepository bikeRepository;

    @GetMapping("{placa}")
    public Bike getBikeById(String placa) {
        log.info("Buscando moto com id:", placa);
        return bikeRepository.findById(placa).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @CacheEvict(value = "bike", allEntries = true)
    @Operation(summary = "Cadastrar moto", description = "Insere uma moto", responses = {
            @ApiResponse(responseCode = "201"),
            @ApiResponse(responseCode = "400"),
    })
    public ResponseEntity<Bike> create(@RequestBody @Valid Bike bike) {
        log.info("Cadastrando moto:" + bike.getPlaca());
        bikeRepository.save(bike);
        return ResponseEntity.status(201).body(bike);
    }

    @DeleteMapping("{placa}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable String placa) {
        log.info("Apagando categoria " + placa);
        bikeRepository.delete(
                bikeRepository.findById(placa).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @PutMapping("{placa}")
    public Bike update(@PathVariable String placa, @RequestBody @Valid Bike bike) {
        log.info("Atualizando moto:" + placa + " " + bike);

        bikeRepository.findById(placa).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        bike.setPlaca(placa);
        bikeRepository.save(bike);

        return bike;
    }
}
