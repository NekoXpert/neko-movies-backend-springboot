package com.autocine.nekomoviesbackend.repositories;

import com.autocine.nekomoviesbackend.models.Confiteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiteriaRepository extends JpaRepository<Confiteria, Long> {
}
