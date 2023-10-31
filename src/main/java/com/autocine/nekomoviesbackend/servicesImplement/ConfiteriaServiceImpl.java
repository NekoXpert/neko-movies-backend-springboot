package com.autocine.nekomoviesbackend.servicesImplement;

import com.autocine.nekomoviesbackend.models.Confiteria;
import com.autocine.nekomoviesbackend.repositories.ConfiteriaRepository;
import com.autocine.nekomoviesbackend.services.ConfiteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfiteriaServiceImpl implements ConfiteriaService {

    @Autowired
    private ConfiteriaRepository confiteriaRepository;

    @Override
    public List<Confiteria> obtenerTodosLosProductos() {
        return confiteriaRepository.findAll();
    }

    @Override
    public Optional<Confiteria> obtenerProductoPorId(Long id) {
        return confiteriaRepository.findById(id);
    }

    @Override
    public Confiteria crearProductoConfiteria(Confiteria confiteria) {
        return confiteriaRepository.save(confiteria);
    }
}

