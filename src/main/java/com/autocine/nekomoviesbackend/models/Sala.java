package com.autocine.nekomoviesbackend.models;

import lombok.Data;


import java.util.List;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "salas")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSala;

    private String nombreSala;
    private Integer capacidad;

    @ManyToOne
    @JoinColumn(name = "id_sede", nullable = false)
    private Sede sede;

    @OneToMany(mappedBy = "sala")
    private List<Funcion> funciones;
}

