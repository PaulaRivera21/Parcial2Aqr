package com.example.BDSpringSD.Controller;

import com.example.BDSpringSD.Model.Consulta;
import com.example.BDSpringSD.Service.ConsultaService;
import com.example.BDSpringSD.Service.MascotaService;
import com.example.BDSpringSD.Service.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private VeterinarioService veterinarioService;

    @GetMapping("/listar")
    public String listarConsultas(Model model) {
        model.addAttribute("consultas", consultaService.listar());
        return "ListarConsultas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarConsulta(@PathVariable Integer id) {
        consultaService.eliminar(id);
        return "redirect:/consultas/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarConsulta(@PathVariable int id, Model model) {
        Consulta consulta = consultaService.editar(id).orElse(new Consulta());
        model.addAttribute("consulta", consulta);
        model.addAttribute("mascotas", mascotaService.listar());
        model.addAttribute("veterinarios", veterinarioService.listar());
        return "FormularioConsulta";
    }

    @PostMapping("/guardar")
    public String guardarConsulta(@ModelAttribute Consulta consulta) {
        consultaService.guardar(consulta);
        return "redirect:/consultas/listar";
    }

    @GetMapping("/crear")
    public String crearConsulta(Model model) {
        model.addAttribute("consulta", new Consulta());
        model.addAttribute("mascotas", mascotaService.listar());
        model.addAttribute("veterinarios", veterinarioService.listar());
        return "FormularioConsulta";
    }
}
