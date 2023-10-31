package com.autocine.nekomoviesbackend.models;

import lombok.Data;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "compras_confiteria")
public class CompraConfiteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompraConfiteria;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Confiteria producto;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "id_transaccion")
    private Transaccion transaccion;
    private Integer cantidad;
    private BigDecimal precioTotal;
}
