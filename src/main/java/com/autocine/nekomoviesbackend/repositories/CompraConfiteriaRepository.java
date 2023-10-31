package com.autocine.nekomoviesbackend.repositories;

import com.autocine.nekomoviesbackend.models.CompraConfiteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraConfiteriaRepository extends JpaRepository<CompraConfiteria, Long> {
}

