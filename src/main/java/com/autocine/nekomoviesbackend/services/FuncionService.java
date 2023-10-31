package com.autocine.nekomoviesbackend.services;

import com.autocine.nekomoviesbackend.models.Funcion;
import com.autocine.nekomoviesbackend.models.Sala;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FuncionService {
    List<Funcion> obtenerFuncionesPorSalaYSemana(Sala sala, LocalDateTime semana);
    Optional<Funcion> obtenerFuncionPorId(Long id);
    Funcion crearFuncion(Funcion funcion);
  
}
