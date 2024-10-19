package org.example.models.medicamento;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Builder
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID paciente_id;
    private String paciente_name;
    private String paciente_lastName;
    private String born_date;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

}
