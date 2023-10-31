package com.autocine.nekomoviesbackend.repositories;

import com.autocine.nekomoviesbackend.models.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long> {
}
