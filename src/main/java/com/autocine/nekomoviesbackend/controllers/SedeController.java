package com.autocine.nekomoviesbackend.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autocine.nekomoviesbackend.models.Sede;
import com.autocine.nekomoviesbackend.services.SedeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/sedes")
@RequiredArgsConstructor
public class SedeController {

    private final SedeService sedeService;

    @GetMapping
    public ResponseEntity<List<Sede>> obtenerTodasLasSedes() {
        List<Sede> sedes = sedeService.obtenerTodasLasSedes();
        return new ResponseEntity<>(sedes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sede> obtenerSedePorId(@PathVariable Long id) {
        return sedeService.obtenerSedePorId(id)
                .map(sede -> new ResponseEntity<>(sede, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

 
}

