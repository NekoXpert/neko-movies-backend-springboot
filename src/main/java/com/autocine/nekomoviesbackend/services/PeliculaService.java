package com.autocine.nekomoviesbackend.services;

import com.autocine.nekomoviesbackend.models.Pelicula;
import java.util.List;
import java.util.Optional;

public interface PeliculaService {
    List<Pelicula> obtenerTodasLasPeliculas();
    Optional<Pelicula> obtenerPeliculaPorId(Long id);
    Pelicula crearPelicula(Pelicula pelicula);
  
}
