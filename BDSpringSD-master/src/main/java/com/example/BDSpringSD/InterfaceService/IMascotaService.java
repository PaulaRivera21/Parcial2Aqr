package com.example.BDSpringSD.InterfaceService;

import com.example.BDSpringSD.Model.Mascota;

import java.util.List;
import java.util.Optional;

public interface IMascotaService {
    public List<Mascota> listar();

    public void guardar(Mascota mascota);

    public Optional<Mascota> editar(int id);

    public void eliminar(int id);
}
