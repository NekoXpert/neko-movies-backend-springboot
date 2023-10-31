package com.autocine.nekomoviesbackend.repositories;

import com.autocine.nekomoviesbackend.models.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedeRepository extends JpaRepository<Sede, Long> {
}
