package com.autocine.nekomoviesbackend.services;

import com.autocine.nekomoviesbackend.models.Confiteria;
import java.util.List;
import java.util.Optional;

public interface ConfiteriaService {
    List<Confiteria> obtenerTodosLosProductos();
    Optional<Confiteria> obtenerProductoPorId(Long id);
    Confiteria crearProductoConfiteria(Confiteria confiteria);  
}
