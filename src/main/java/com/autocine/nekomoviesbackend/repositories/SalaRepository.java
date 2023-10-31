package com.autocine.nekomoviesbackend.repositories;

import com.autocine.nekomoviesbackend.models.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {
}
