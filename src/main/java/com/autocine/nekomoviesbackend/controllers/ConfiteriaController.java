package com.autocine.nekomoviesbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.autocine.nekomoviesbackend.models.Confiteria;
import com.autocine.nekomoviesbackend.services.ConfiteriaService;

@RestController
@RequestMapping("/api/confiteria")
public class ConfiteriaController {

    @Autowired
    private ConfiteriaService confiteriaService;

    @PostMapping("/crear")
    public ResponseEntity<Confiteria> crearProductoConfiteria(@RequestBody Confiteria confiteria) {
        Confiteria nuevoProducto = confiteriaService.crearProductoConfiteria(confiteria);  
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Confiteria> obtenerProductoConfiteria(@PathVariable Long id) {
        return confiteriaService.obtenerProductoPorId(id)  
                .map(producto -> new ResponseEntity<>(producto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

  
}
