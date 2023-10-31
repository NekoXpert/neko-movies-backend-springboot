package com.autocine.nekomoviesbackend.controllers;

import com.autocine.nekomoviesbackend.models.Entrada;
import com.autocine.nekomoviesbackend.services.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entradas")
public class EntradaController {

    @Autowired
    private EntradaService entradaService;

    @PostMapping("/crear")
    public ResponseEntity<Entrada> crearEntrada(@RequestParam Long idFuncion, @RequestParam Long idUsuario, @RequestParam Integer cantidad, @RequestParam String ubicacionAuto) {
        Entrada nuevaEntrada = entradaService.comprarEntrada(idFuncion, idUsuario, cantidad, ubicacionAuto);
        return new ResponseEntity<>(nuevaEntrada, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrada> obtenerEntrada(@PathVariable Long id) {
        return entradaService.obtenerEntradaPorId(id)
                .map(entrada -> new ResponseEntity<>(entrada, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

   
}
