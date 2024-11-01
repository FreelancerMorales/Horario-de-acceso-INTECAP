package com.clase5.clase5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.clase5.clase5.model.HorarioAcceso;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HorarioVistaController {

    private List<HorarioAcceso> horarios = new ArrayList<>();

    @GetMapping("/")
    public String listarHorarios(Model model) {
        model.addAttribute("horarios", horarios);
        return "listar";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("horario", new HorarioAcceso());
        model.addAttribute("titulo", "Crear Horario");
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardarHorario(@ModelAttribute HorarioAcceso horario) {
        horario.setId((long) (horarios.size() + 1));
        horarios.add(horario);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        HorarioAcceso horario = horarios.stream()
                .filter(h -> h.getId().equals(id))
                .findFirst()
                .orElse(null);
    
        if (horario != null) {
            model.addAttribute("horario", horario);
            model.addAttribute("titulo", "Editar Horario");
            return "formulario";
        } else {
            return "redirect:/";
        }
    }


    @PostMapping("/actualizar/{id}")
    public String actualizarHorario(@PathVariable Long id, @ModelAttribute HorarioAcceso horarioActualizado) {
        for (int i = 0; i < horarios.size(); i++) {
            HorarioAcceso h = horarios.get(i);
            if (h.getId().equals(id)) {
                horarioActualizado.setId(id);
                horarios.set(i, horarioActualizado);
                break;
            }
        }
        return "redirect:/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarHorario(@PathVariable Long id) {
        horarios.removeIf(h -> h.getId().equals(id));
        return "redirect:/";
    }
}
