package com.fiap.sprint1_java2025.controller;

import com.fiap.sprint1_java2025.model.Pending;
import com.fiap.sprint1_java2025.repository.PendingRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("pendings")
public class PendingController {

    Logger log = LoggerFactory.getLogger(PendingController.class);

    @Autowired
    private PendingRepository repository;

    @GetMapping
    @Cacheable("pendings")
    public Page<Pending> index(
            @PageableDefault(size = 10, sort = "id", direction = Direction.DESC) Pageable pageable) {
        return repository.findAll(pageable);
    }

    @PostMapping
    @CacheEvict(value = "pendings", allEntries = true)
    @Operation(summary = "Cadastrar pendência", description = "Cria uma nova pendência", responses = {
            @ApiResponse(responseCode = "201"),
            @ApiResponse(responseCode = "400"),
    })
    public ResponseEntity<Pending> create(@RequestBody Pending pending) {
        log.info("Criando nova pendência...");
        repository.save(pending);
        return ResponseEntity.status(HttpStatus.CREATED).body(pending);
    }

    @GetMapping("{id}")
    public Pending show(@PathVariable Long id) {
        return getPending(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CacheEvict(value = "pendings", allEntries = true)
    public void destroy(@PathVariable Long id) {
        log.info("Deletando pendência " + id);
        repository.delete(getPending(id));
    }

    @PutMapping("{id}")
    @CacheEvict(value = "pendings", allEntries = true)
    public Pending update(@PathVariable Long id, @RequestBody Pending pending) {
        log.info("Atualizando pendência " + id);
        getPending(id); // Verifica se existe
        pending.setId(id);
        return repository.save(pending);
    }

    private Pending getPending(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pendência não encontrada"));
    }
}
