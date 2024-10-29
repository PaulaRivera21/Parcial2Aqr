package com.example.BDSpringSD.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Propietario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String telefono;
    private String direccion;

    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL)
    private List<Mascota> mascotas;
}
