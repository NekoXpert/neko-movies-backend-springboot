package com.autocine.nekomoviesbackend.services;

import com.autocine.nekomoviesbackend.models.Sede;
import java.util.List;
import java.util.Optional;

public interface SedeService {
    List<Sede> obtenerTodasLasSedes();
    Optional<Sede> obtenerSedePorId(Long id);
  
}
