package com.autocine.nekomoviesbackend.servicesImplement;

import com.autocine.nekomoviesbackend.models.Entrada;
import com.autocine.nekomoviesbackend.models.Funcion;
import com.autocine.nekomoviesbackend.models.Usuario;
import com.autocine.nekomoviesbackend.repositories.EntradaRepository;
import com.autocine.nekomoviesbackend.repositories.FuncionRepository;
import com.autocine.nekomoviesbackend.repositories.UsuarioRepository;
import com.autocine.nekomoviesbackend.services.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class EntradaServiceImpl implements EntradaService {

    @Autowired
    private EntradaRepository entradaRepository;
    @Autowired
    private FuncionRepository funcionRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Entrada comprarEntrada(Long idFuncion, Long idUsuario, Integer cantidad, String ubicacionAuto) {
      
        Funcion funcion = funcionRepository.findById(idFuncion)
                .orElseThrow(() -> new IllegalArgumentException("Función no encontrada"));
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

     
        if (funcion == null) {
            throw new IllegalArgumentException("La función no puede ser null");
        }
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser null");
        }
        if (cantidad == null || cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        if (ubicacionAuto == null || ubicacionAuto.trim().isEmpty()) {
            throw new IllegalArgumentException("La ubicación del auto no puede estar vacía");
        }

        // Creación y configuración de la nueva entrada
        Entrada nuevaEntrada = new Entrada();
        nuevaEntrada.setFuncion(funcion);
        nuevaEntrada.setUsuario(usuario);
        nuevaEntrada.setCantidad(cantidad);
        nuevaEntrada.setUbicacionAuto(ubicacionAuto);

        // Cálculo del precio total
        BigDecimal precioTotal = funcion.getPrecio().multiply(new BigDecimal(cantidad));
        nuevaEntrada.setPrecioTotal(precioTotal);

        // Guardar y retornar la nueva entrada
        return entradaRepository.save(nuevaEntrada);
    }

    @Override
    public Optional<Entrada> obtenerEntradaPorId(Long id) {
        return entradaRepository.findById(id);
    }
}
