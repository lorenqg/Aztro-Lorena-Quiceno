package org.example.models.supermercado;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_compra;
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Cliente cliente;

    @OneToOne
    @JoinTable(name = "producto_id")
    private Producto producto;
}
