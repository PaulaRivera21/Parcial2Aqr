package com.example.BDSpringSD.Controller;

import com.example.BDSpringSD.Model.Mascota;
import com.example.BDSpringSD.Model.Propietario;
import com.example.BDSpringSD.Service.MascotaService;
import com.example.BDSpringSD.Service.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private PropietarioService propietarioService;

    @GetMapping("/listar")
    public String listarMascotas(Model model) {
        model.addAttribute("mascotas", mascotaService.listar());
        return "ListarMascotas"; // Nombre del archivo HTML
    }

    @GetMapping("/listar/eliminar/{id}")
    public String eliminarMascota(@PathVariable Integer id) {
        mascotaService.eliminar(id); // Eliminar la mascota
        return "redirect:/mascotas/listar";
    }

    @GetMapping("/listar/editar/{id}")
    public String editarMascota(@PathVariable int id, Model model) {
        Mascota mascota = mascotaService.editar(id).orElse(new Mascota());
        model.addAttribute("mascota", mascota);
        return "FormularioMascota"; // Nombre del formulario para editar
    }

    @PostMapping("/guardar")
    public String guardarPropietario(@ModelAttribute Propietario propietario) {
        propietarioService.guardar(propietario);
        return "redirect:/propietarios/listar";
    }


    @GetMapping("/crear")
    public String crearMascota(Model model) {
        model.addAttribute("mascota", new Mascota());
        return "FormularioMascota";
    }
}
