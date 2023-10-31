package com.autocine.nekomoviesbackend.models;

import lombok.Data;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "transacciones")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaccion;
    @OneToMany(mappedBy = "transaccion")
    private List<Entrada> entradas;

    @OneToMany(mappedBy = "transaccion")
    private List<CompraConfiteria> comprasConfiteria;
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    private LocalDateTime fechaHora;
    private BigDecimal montoTotal;
    private String detalle; // @Column(columnDefinition = "jsonb")
  
}

