package com.autocine.nekomoviesbackend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.autocine.nekomoviesbackend.models.Sala;
import com.autocine.nekomoviesbackend.services.SalaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/salas")
@RequiredArgsConstructor
public class SalaController {

    private final SalaService salaService;

    @PostMapping
    public ResponseEntity<Sala> crearSala(@RequestBody Sala sala) {
        try {
            Sala nuevaSala = salaService.crearSala(sala);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaSala);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> obtenerSala(@PathVariable Long id) {
        return salaService.obtenerSalaPorId(id)
                .map(sala -> ResponseEntity.ok(sala))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
