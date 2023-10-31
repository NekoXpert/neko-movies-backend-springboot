package com.autocine.nekomoviesbackend.servicesImplement;

import com.autocine.nekomoviesbackend.models.Funcion;
import com.autocine.nekomoviesbackend.models.Sala;
import com.autocine.nekomoviesbackend.repositories.FuncionRepository;
import com.autocine.nekomoviesbackend.services.FuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionServiceImpl implements FuncionService {

    private final FuncionRepository funcionRepository;

    @Autowired
    public FuncionServiceImpl(FuncionRepository funcionRepository) {
        this.funcionRepository = funcionRepository;
    }

    @Override
    public List<Funcion> obtenerFuncionesPorSalaYSemana(Sala sala, LocalDateTime semana) {
        LocalDateTime inicioSemana = semana.with(DayOfWeek.MONDAY).toLocalDate().atStartOfDay();
        LocalDateTime finSemana = semana.with(DayOfWeek.SUNDAY).toLocalDate().atTime(LocalTime.MAX);
        return funcionRepository.findBySalaAndFechaHoraBetween(sala, inicioSemana, finSemana);
    }

    @Override
    public Optional<Funcion> obtenerFuncionPorId(Long id) {
        return funcionRepository.findById(id);
    }

    @Override
    public Funcion crearFuncion(Funcion funcion) {
        return funcionRepository.save(funcion);
    }
}
