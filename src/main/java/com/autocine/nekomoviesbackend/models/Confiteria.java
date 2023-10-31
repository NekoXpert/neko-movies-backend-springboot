package com.autocine.nekomoviesbackend.models;

import lombok.Data;


import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.*;

@Data // @Getter @Setter @ToString @EqualsAndHashCode @RequiredArgsConstructor
@Entity
@Table(name = "confiteria")
public class Confiteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    private String nombreProducto;
    private String descripcion;
    private BigDecimal precio;
    private String imagen;

    @OneToMany(mappedBy = "producto")
    private List<CompraConfiteria> comprasConfiteria;
}

