package org.example.models.supermercado;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_marca;
    private String nombre_marca;
    private String pais;

    @OneToMany(mappedBy = "id_producto")
    private List<Producto> productos;


}
