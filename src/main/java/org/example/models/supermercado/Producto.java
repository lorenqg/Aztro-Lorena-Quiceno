package org.example.models.supermercado;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_producto;
    private String nombre_producto;
    private String precio;


    @ManyToOne
    @JoinColumn(name = "marca")
    private Marca marca;


}
