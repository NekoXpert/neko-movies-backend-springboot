package com.autocine.nekomoviesbackend.servicesImplement;

import com.autocine.nekomoviesbackend.dto.UsuarioDTO;
import com.autocine.nekomoviesbackend.models.Usuario;
import com.autocine.nekomoviesbackend.repositories.UsuarioRepository;
import com.autocine.nekomoviesbackend.services.UsuarioService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        usuario.setPassword(BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioDTO login(String email, String password) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (BCrypt.checkpw(password, usuario.getPassword())) {
            return convertirAUsuarioDTO(usuario);
        } else {
            throw new RuntimeException("Contraseña incorrecta");
        }
    }

    private UsuarioDTO convertirAUsuarioDTO(Usuario usuario) {
        return new UsuarioDTO(usuario.getNombreUsuario(), usuario.getEmail());
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public Optional<Usuario> buscarPorNombreUsuario(String nombreUsuario) {
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }
}
