package org.example.models.prestamo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_autor;
    private String autor_name;
    private String autor_age;
    private String autor_nacionality;

    @OneToMany(mappedBy = "autor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Libro> libros;






}
