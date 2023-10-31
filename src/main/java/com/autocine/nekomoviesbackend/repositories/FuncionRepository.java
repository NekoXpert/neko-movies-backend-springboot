package com.autocine.nekomoviesbackend.repositories;

import com.autocine.nekomoviesbackend.models.Funcion;
import com.autocine.nekomoviesbackend.models.Sala;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionRepository extends JpaRepository<Funcion, Long> {
    List<Funcion> findBySalaAndFechaHoraBetween(Sala sala, LocalDateTime inicio, LocalDateTime fin);

}