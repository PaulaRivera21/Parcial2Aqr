package com.example.BDSpringSD.Controller;

import com.example.BDSpringSD.Model.Veterinario;
import com.example.BDSpringSD.Service.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/veterinarios")
public class VeterinarioController {

    @Autowired
    private VeterinarioService veterinarioService;

    @GetMapping("/listar")
    public String listarVeterinarios(Model model) {
        List<Veterinario> veterinarios = veterinarioService.listar();
        model.addAttribute("veterinarios", veterinarios);
        return "ListarVeterinarios";
    }

    @GetMapping("listar/eliminar/{id}")
    public String eliminarVeterinario(@PathVariable Integer id) {
        veterinarioService.eliminar(id);
        return "redirect:/veterinarios/listar";
    }

    @GetMapping("listar/editar/{id}")
    public String editarVeterinario(@PathVariable int id, Model model) {
        Veterinario veterinario = veterinarioService.editar(id).orElse(new Veterinario());
        model.addAttribute("veterinario", veterinario);
        return "FormularioVeterinario";
    }

    @PostMapping("/guardar")
    public String guardarVeterinario(@ModelAttribute Veterinario veterinario) {
        veterinarioService.guardar(veterinario);
        return "redirect:/veterinarios/listar";
    }


    @GetMapping("/crear")
    public String crearVeterinario(Model model) {
        model.addAttribute("veterinario", new Veterinario());
        return "FormularioVeterinario";
    }
}
