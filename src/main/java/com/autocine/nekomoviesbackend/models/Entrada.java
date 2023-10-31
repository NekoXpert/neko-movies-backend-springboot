package com.autocine.nekomoviesbackend.models;

import lombok.Data;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "entradas")
public class Entrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntrada;

    @ManyToOne
    @JoinColumn(name = "id_funcion", nullable = false)
    private Funcion funcion;
    @ManyToOne
    @JoinColumn(name = "id_transaccion")
    private Transaccion transaccion;
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    private Integer cantidad;
    private String ubicacionAuto;
    private BigDecimal precio;
    private BigDecimal precioTotal;
}
