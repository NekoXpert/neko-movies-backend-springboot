package com.autocine.nekomoviesbackend.servicesImplement;

import com.autocine.nekomoviesbackend.models.Transaccion;
import com.autocine.nekomoviesbackend.models.Usuario;
import com.autocine.nekomoviesbackend.repositories.TransaccionRepository;
import com.autocine.nekomoviesbackend.services.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TransaccionServiceImpl implements TransaccionService {

    private final TransaccionRepository transaccionRepository;

    @Autowired
    public TransaccionServiceImpl(TransaccionRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }

    @Override
    public Transaccion crearTransaccion(Transaccion transaccion) {
    
        return transaccionRepository.save(transaccion);
    }

    @Override
    public Optional<Transaccion> obtenerTransaccionPorId(Long id) {
    
        return transaccionRepository.findById(id);
    }

    @Override
    public Transaccion realizarTransaccion(Usuario usuario, BigDecimal monto, String detalle) {
        Transaccion nuevaTransaccion = new Transaccion();
        nuevaTransaccion.setUsuario(usuario);
        nuevaTransaccion.setMontoTotal(monto);
        nuevaTransaccion.setDetalle(detalle);
        nuevaTransaccion.setFechaHora(LocalDateTime.now());
        return transaccionRepository.save(nuevaTransaccion);
    }
}
