package org.example.repositories.supermercado;

import org.example.configs.EntityManagerPostgres;
import org.example.models.supermercado.Compra;
import org.example.repositories.AbstractRepository;

public class CompraRepository extends AbstractRepository<Compra> {

    public CompraRepository() {
        super(new EntityManagerPostgres<>());
    }
}
