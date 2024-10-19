package org.example.models.medicamento;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int venta_id;
    private String fecha_venta;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @OneToOne
    @JoinColumn(name = "medicamento_id")
    private Medicamento medicamento;

}
