package com.example.BDSpringSD.InterfaceService;

import com.example.BDSpringSD.Model.Propietario;

import java.util.List;
import java.util.Optional;

public interface IPropietarioService {
    List<Propietario> listar();
    void guardar(Propietario propietario);
    Optional<Propietario> editar(int id);
    void eliminar(int id);
}
