package com.autocine.nekomoviesbackend.controllers;

import com.autocine.nekomoviesbackend.dto.LoginRequest;
import com.autocine.nekomoviesbackend.dto.UsuarioDTO;
import com.autocine.nekomoviesbackend.models.Usuario;
import com.autocine.nekomoviesbackend.services.UsuarioService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioRegistrado = usuarioService.registrarUsuario(usuario);
        return ResponseEntity.ok(usuarioRegistrado);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Usuario> buscarPorEmail(@PathVariable String email) {
        return usuarioService.buscarPorEmail(email)
                .map(usuario -> ResponseEntity.ok(usuario))
                .orElse(ResponseEntity.notFound().build());
    }

  @PostMapping("/login")
public ResponseEntity<UsuarioDTO> login(@RequestBody LoginRequest loginRequest) {
    UsuarioDTO usuarioDTO = usuarioService.login(loginRequest.getEmail(), loginRequest.getPassword());
    return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
}


    @GetMapping("/nombreUsuario/{nombreUsuario}")
    public ResponseEntity<Usuario> buscarPorNombreUsuario(@PathVariable String nombreUsuario) {
        return usuarioService.buscarPorNombreUsuario(nombreUsuario)
                .map(usuario -> ResponseEntity.ok(usuario))
                .orElse(ResponseEntity.notFound().build());
    }
}
