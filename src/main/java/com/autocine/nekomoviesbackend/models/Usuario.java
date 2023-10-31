package com.autocine.nekomoviesbackend.models;

import lombok.Data;


import java.util.List;



import jakarta.persistence.*;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nombreUsuario;
    
    private String dni;
  
    private String email;
    private String placaAuto;
    private String password; 

    @OneToMany(mappedBy = "usuario")
    private List<Entrada> entradas;

    @OneToMany(mappedBy = "usuario")
    private List<CompraConfiteria> comprasConfiteria;

    @OneToMany(mappedBy = "usuario")
    private List<Transaccion> transacciones;
}

