package com.autocine.nekomoviesbackend.servicesImplement;

import com.autocine.nekomoviesbackend.models.Sede;

import com.autocine.nekomoviesbackend.repositories.SedeRepository;
import com.autocine.nekomoviesbackend.services.SedeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service

public class SedeServiceImpl implements SedeService {

    private final SedeRepository sedeRepository;
 @Autowired
    public SedeServiceImpl(SedeRepository sedeRepository) {
        this.sedeRepository = sedeRepository;
    }
    @Override
    public List<Sede> obtenerTodasLasSedes() {
        return sedeRepository.findAll();
    }

    @Override
    public Optional<Sede> obtenerSedePorId(Long id) {
        return sedeRepository.findById(id);
    }
}
