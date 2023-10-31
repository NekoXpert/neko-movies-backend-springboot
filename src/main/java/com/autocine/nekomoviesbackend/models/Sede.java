package com.autocine.nekomoviesbackend.models;

import lombok.Data;


import java.util.List;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "sedes")
public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSede;

    private String direccion;
    private String nombreSede;

    @OneToMany(mappedBy = "sede")
    private List<Sala> salas;
}
