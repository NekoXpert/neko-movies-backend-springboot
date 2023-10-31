package com.autocine.nekomoviesbackend.models;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "peliculas")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPelicula;

    private String titulo;
    private String sinopsis;
    private Time duracion;
    private String genero;
    private Date fechaEstreno;

    @OneToMany(mappedBy = "pelicula")
    private List<Funcion> funciones;
}
