package org.example.models.medicamento;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Builder
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sucursal_id;
    private String nombre_sucursal;
    private String direccion_sucursal;

    @ManyToMany
    @JoinTable(name = "sucursal_medicamento",
            joinColumns = @JoinColumn(name = "sucursal_id"),
            inverseJoinColumns = @JoinColumn(name = "medicamento_id"))
    private List<Medicamento> medicamentos;
}
