package com.autocine.nekomoviesbackend.servicesImplement;

import com.autocine.nekomoviesbackend.models.Sala;
import com.autocine.nekomoviesbackend.repositories.SalaRepository;
import com.autocine.nekomoviesbackend.services.SalaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service

public class SalaServiceImpl implements SalaService {

    private final SalaRepository salaRepository;

    @Autowired
    public SalaServiceImpl(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }
    @Override
    public List<Sala> obtenerTodasLasSalas() {
        return salaRepository.findAll();
    }

    @Override
    public Optional<Sala> obtenerSalaPorId(Long id) {
        return salaRepository.findById(id);
    }

    @Override
    public Sala crearSala(Sala sala) {
        return salaRepository.save(sala);
    }
}
