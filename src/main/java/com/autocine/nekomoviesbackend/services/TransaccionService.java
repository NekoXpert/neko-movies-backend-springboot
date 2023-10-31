package com.autocine.nekomoviesbackend.services;

import com.autocine.nekomoviesbackend.models.Transaccion;
import com.autocine.nekomoviesbackend.models.Usuario;

import java.math.BigDecimal;
import java.util.Optional;

public interface TransaccionService {
    Transaccion crearTransaccion(Transaccion transaccion);
    Optional<Transaccion> obtenerTransaccionPorId(Long id);
    Transaccion realizarTransaccion(Usuario usuario, BigDecimal monto, String detalle);
    
}
