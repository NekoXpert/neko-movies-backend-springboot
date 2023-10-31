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

import com.autocine.nekomoviesbackend.models.Pelicula;
import com.autocine.nekomoviesbackend.services.PeliculaService;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @PostMapping("/crear")
    public ResponseEntity<Pelicula> crearPelicula(@RequestBody Pelicula pelicula) {
        Pelicula nuevaPelicula = peliculaService.crearPelicula(pelicula);
        return new ResponseEntity<>(nuevaPelicula, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> obtenerPelicula(@PathVariable Long id) {
        return peliculaService.obtenerPeliculaPorId(id)
                .map(pelicula -> new ResponseEntity<>(pelicula, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

  
}

