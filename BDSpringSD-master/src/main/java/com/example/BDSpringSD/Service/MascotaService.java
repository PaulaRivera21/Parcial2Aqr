package com.example.BDSpringSD.Service;

import com.example.BDSpringSD.InterfaceService.IMascotaService;
import com.example.BDSpringSD.Model.Mascota;
import com.example.BDSpringSD.Repository.RMascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService implements IMascotaService {

    @Autowired
    private RMascota repository;


    @Override
    public List<Mascota> listar() {
        return repository.findAll();
    }

    @Override
    public void guardar(Mascota mascota) {
        repository.save(mascota);
    }

    @Override
    public Optional<Mascota> editar(int id) {
        return repository.findById(id);
    }

    @Override
    public void eliminar(int id) {

        repository.deleteById(id);

    }
}
