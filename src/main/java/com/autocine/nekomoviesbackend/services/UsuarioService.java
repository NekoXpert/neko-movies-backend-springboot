package com.autocine.nekomoviesbackend.services;

import com.autocine.nekomoviesbackend.dto.UsuarioDTO;
import com.autocine.nekomoviesbackend.models.Usuario;
import java.util.Optional;

public interface UsuarioService {
    Usuario registrarUsuario(Usuario usuario);
    UsuarioDTO login(String email, String password);
    Optional<Usuario> buscarPorEmail(String email);
    Optional<Usuario> buscarPorNombreUsuario(String nombreUsuario);
    
}
