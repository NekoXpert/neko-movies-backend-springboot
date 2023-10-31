package com.autocine.nekomoviesbackend.services;

import java.util.Optional;

import com.autocine.nekomoviesbackend.models.CompraConfiteria;


public interface CompraConfiteriaService {
    CompraConfiteria crearCompraConfiteria(CompraConfiteria compraConfiteria);
    Optional<CompraConfiteria> obtenerCompraConfiteriaPorId(Long id);

}

