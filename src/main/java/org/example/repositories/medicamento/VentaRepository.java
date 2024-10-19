package org.example.repositories.medicamento;

import org.example.configs.EntityManagerPostgres;
import org.example.models.medicamento.Venta;
import org.example.repositories.AbstractRepository;

public class VentaRepository extends AbstractRepository<Venta> {

    public VentaRepository() {
        super(new EntityManagerPostgres<>());
    }

}
