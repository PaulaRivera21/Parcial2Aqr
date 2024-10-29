package com.example.BDSpringSD.Controller;

import com.example.BDSpringSD.Model.Propietario;
import com.example.BDSpringSD.Service.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/propietarios")
public class PropietarioController {

    @Autowired
    private PropietarioService propietarioService;

    @GetMapping("/listar")
    public String listarPropietarios(Model model) {
        model.addAttribute("propietarios", propietarioService.listar());
        return "ListarPropietarios";
    }

    @GetMapping("/listar/eliminar/{id}")
    public String eliminarPropietario(@PathVariable Integer id) {
        propietarioService.eliminar(id);
        return "redirect:/propietarios/listar";
    }

    @GetMapping("/listar/editar/{id}")
    public String editarPropietario(@PathVariable int id, Model model) {
        Propietario propietario = propietarioService.editar(id).orElse(new Propietario());
        model.addAttribute("propietario", propietario);
        return "FormularioPropietario";
    }

    @PostMapping("/guardar")
    public String guardarPropietario(@ModelAttribute Propietario propietario) {
        propietarioService.guardar(propietario);
        return "redirect:/propietarios/listar";
    }


    @GetMapping("/crear")
    public String crearPropietario(Model model) {
        model.addAttribute("propietario", new Propietario());
        return "FormularioPropietario";
    }
}

