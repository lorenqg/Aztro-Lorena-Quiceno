package org.example.models.medicamento;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID medico_id;
    private String medico_name;
    private String medico_lastName;
    private String tarjeta_profesional;

    @OneToMany(mappedBy = "medico")
    private List<Paciente> pacientes;


}
