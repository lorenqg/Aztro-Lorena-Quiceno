package org.example.models.medicamento;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Builder
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int medicamento_id;
    private String nombre_medicamento;
    private String descripcion;
    private double precio;

    @ManyToMany
    @JoinTable(name = "sucursal_medicamento",
            joinColumns = @JoinColumn(name = "sucursal_id"),
            inverseJoinColumns = @JoinColumn(name = "medicamento_id"))
    private List<Sucursal> sucursales;

}
