package com.autocine.nekomoviesbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autocine.nekomoviesbackend.models.Funcion;
import com.autocine.nekomoviesbackend.services.FuncionService;

@RestController
@RequestMapping("/api/funciones")
public class FuncionController {

    @Autowired
    private FuncionService funcionService;

    @PostMapping("/crear")
    public ResponseEntity<Funcion> crearFuncion(@RequestBody Funcion funcion) {
        Funcion nuevaFuncion = funcionService.crearFuncion(funcion);
        return new ResponseEntity<>(nuevaFuncion, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcion> obtenerFuncion(@PathVariable Long id) {
        return funcionService.obtenerFuncionPorId(id)
                .map(funcion -> new ResponseEntity<>(funcion, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

  
}

