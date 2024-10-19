package org.example.models.supermercado;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID client_id;
    private String client_name;
    private String client_lastName;
    private String client_number;
    private String cedula_client;

    @OneToMany(mappedBy = "id_compra")
    private List<Compra> compras;


}
