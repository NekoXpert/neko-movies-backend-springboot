package com.autocine.nekomoviesbackend.repositories;

import com.autocine.nekomoviesbackend.models.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
}
