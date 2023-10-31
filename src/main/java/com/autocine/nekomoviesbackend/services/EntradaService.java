package com.autocine.nekomoviesbackend.services;

import com.autocine.nekomoviesbackend.models.Entrada;

import java.util.Optional;

public interface EntradaService {
    Entrada comprarEntrada(Long idFuncion, Long idUsuario, Integer cantidad, String ubicacionAuto);
    Optional<Entrada> obtenerEntradaPorId(Long id);
  
}
