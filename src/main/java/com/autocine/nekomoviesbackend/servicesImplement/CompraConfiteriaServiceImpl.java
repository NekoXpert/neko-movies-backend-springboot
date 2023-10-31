package com.autocine.nekomoviesbackend.servicesImplement;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autocine.nekomoviesbackend.models.CompraConfiteria;

import com.autocine.nekomoviesbackend.repositories.CompraConfiteriaRepository;
import com.autocine.nekomoviesbackend.services.CompraConfiteriaService;

@Service
public class CompraConfiteriaServiceImpl implements CompraConfiteriaService {

    @Autowired
    private CompraConfiteriaRepository compraConfiteriaRepository;

    @Override
    public CompraConfiteria crearCompraConfiteria(CompraConfiteria compraConfiteria) {
        return compraConfiteriaRepository.save(compraConfiteria);
    }

    @Override
    public Optional<CompraConfiteria> obtenerCompraConfiteriaPorId(Long id) {
        return compraConfiteriaRepository.findById(id);
    }
}
