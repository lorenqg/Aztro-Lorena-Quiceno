package org.example;

import org.example.models.supermercado.*;
import org.example.repositories.supermercado.*;

import org.example.models.empleado.*;
import org.example.models.empleado.Empleado;
import org.example.repositories.empleado.*;

import org.example.models.curso.*;
import org.example.repositories.curso.*;
import org.example.models.medicamento.*;
import org.example.repositories.medicamento.*;

import org.example.models.cita.*;
import org.example.repositories.cita.*;

import org.example.models.prestamo.*;
import org.example.repositories.prestamo.*;


import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        // MEDICAMENTOS

        // Repositorios
        MedicamentoRepository medicamentoRepository = new MedicamentoRepository();
        MedicoRepository medicoRepository = new MedicoRepository();
        PacienteRepository pacienteRepository = new PacienteRepository();
        SucursalRepository sucursalRepository = new SucursalRepository();
        VentaRepository ventaRepository = new VentaRepository();

        //Registros
        Sucursal sucursal1 = Sucursal.builder()
                .nombre_sucursal("Oriental")
                .direccion_sucursal("Av Oriental..")
                .build();
        sucursalRepository.create(sucursal1);

        Medicamento medi1 = Medicamento.builder()
                .nombre_medicamento("Loratadina")
                .descripcion("Alergias...")
                .precio(20000)
                .sucursales(List.of(sucursal1))
                .build();
        medicamentoRepository.create(medi1);

        Paciente paciente = Paciente.builder()
                .paciente_name("Juan")
                .paciente_lastName("Perez")
                .born_date("10-04-1988")
                .build();
        pacienteRepository.create(paciente);

        Medico med1 = Medico.builder()
                .medico_name("Luis")
                .medico_lastName("Londoño")
                .tarjeta_profesional("10210200")
                .pacientes(List.of(paciente))
                .build();
        medicoRepository.create(med1);

        Venta venta = Venta.builder()
                .fecha_venta("10-10-2025")
                .paciente(paciente)
                .medico(med1)
                .medicamento(medi1)
                .build();
        ventaRepository.create(venta);

        medicamentoRepository.findAll().forEach(System.out::println);
        medicoRepository.findAll().forEach(System.out::println);
        pacienteRepository.findAll().forEach(System.out::println);
        sucursalRepository.findAll().forEach(System.out::println);
        ventaRepository.findAll().forEach(System.out::println);

        medicamentoRepository.close();
        medicoRepository.close();
        pacienteRepository.close();
        sucursalRepository.close();
        ventaRepository.close();

        // ----------------------------------------------------

        // PRESTAMO DE LIBROS

        // Repositorios
        UsuarioRepository usuarioRepository = new UsuarioRepository();
        AutorRepository autorRepository = new AutorRepository();
        LibroRepository libroRepository = new LibroRepository();
        PrestamoRepository prestamoRepository = new PrestamoRepository();

        // Registros
        Usuario user1 = Usuario.builder()
                .user_name("lorena")
                .celphone_number("3245887367")
                .id_number("1082882294")
                .build();

        Usuario user2 = new Usuario();
        user2.setUser_name("María");
        user2.setCelphone_number("3205226030");
        user2.setId_number("21475707");

        usuarioRepository.create(user1);
        usuarioRepository.create(user2);

        Libro libro1 = Libro.builder()
                .nombre_libro("Cien años de soledad")
                .fecha_publicacion("1967")
                .descripcion("En macondo...")
                //.autor(autor1)
                .build();

        Libro libro2 = Libro.builder()
                .nombre_libro("El amor en los tiempos de colera")
                .fecha_publicacion("1985")
                .descripcion("El amor...")
                //.autor(autor1)
                .build();

        Libro libro3 = Libro.builder()
                .nombre_libro("En agosto nos vemos")
                .fecha_publicacion("2024")
                .descripcion("Agosto...")
                //.autor(autor1)
                .build();

        Autor autor1 = Autor.builder()
                .autor_name("Gabriel Garcia Marquez")
                .autor_age("...")
                .autor_nacionality("Colombiano")
                .libros((List.of(libro1, libro2, libro3)))
                .build();
        autorRepository.create(autor1);


        Prestamo prestamo1 = Prestamo.builder()
                .user(user2)
                .fecha_inicio(LocalDate.now())
                .fecha_entrega(LocalDate.now().plusMonths(1))
                .numero_extensiones("2")
                .libro(libro1)
                .build();

        Prestamo prestamo2 = Prestamo.builder()
                .user(user1)
                .fecha_inicio(LocalDate.now())
                .fecha_entrega(LocalDate.now().plusMonths(1))
                .numero_extensiones("2")
                .libro(libro2)
                .build();

        prestamoRepository.create(prestamo2);
        prestamoRepository.create(prestamo1);

        usuarioRepository.findAll().forEach(System.out::println);
        autorRepository.findAll().forEach(System.out::println);
        libroRepository.findAll().forEach(System.out::println);
        prestamoRepository.findAll().forEach(System.out::println);

        usuarioRepository.close();
        autorRepository.close();
        libroRepository.close();
        prestamoRepository.close();

    }
}