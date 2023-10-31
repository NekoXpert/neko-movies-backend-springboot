package com.autocine.nekomoviesbackend.services;

import com.autocine.nekomoviesbackend.models.Sala;
import java.util.List;
import java.util.Optional;

public interface SalaService {
    List<Sala> obtenerTodasLasSalas();
    Optional<Sala> obtenerSalaPorId(Long id);
    Sala crearSala(Sala sala);
}

