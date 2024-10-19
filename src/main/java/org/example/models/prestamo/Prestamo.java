package org.example.models.prestamo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prestamo_id;
    private LocalDate fecha_inicio;
    private LocalDate fecha_entrega;
    private String numero_extensiones;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario user;

    @OneToOne
    @JoinColumn(name = "id_libro")
    private Libro libro;



}
