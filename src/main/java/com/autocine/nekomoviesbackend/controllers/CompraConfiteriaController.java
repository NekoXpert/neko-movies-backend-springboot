package com.autocine.nekomoviesbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.autocine.nekomoviesbackend.models.CompraConfiteria;
import com.autocine.nekomoviesbackend.services.CompraConfiteriaService;

@RestController
@RequestMapping("/api/comprasConfiteria")
public class CompraConfiteriaController {

    @Autowired
    private CompraConfiteriaService compraConfiteriaService;

    @PostMapping("/crear")
    public ResponseEntity<CompraConfiteria> crearCompraConfiteria(@RequestBody CompraConfiteria compraConfiteria) {
        CompraConfiteria nuevaCompraConfiteria = compraConfiteriaService.crearCompraConfiteria(compraConfiteria);
        return new ResponseEntity<>(nuevaCompraConfiteria, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompraConfiteria> obtenerCompraConfiteria(@PathVariable Long id) {
        return compraConfiteriaService.obtenerCompraConfiteriaPorId(id)
                .map(compraConfiteria -> new ResponseEntity<>(compraConfiteria, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
