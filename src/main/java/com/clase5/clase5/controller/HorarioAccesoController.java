package com.clase5.clase5.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.clase5.clase5.model.HorarioAcceso;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/horarios")
public class HorarioAccesoController {

    private List<com.clase5.clase5.model.HorarioAcceso> horarios = new ArrayList<>();

    @GetMapping
    public List<HorarioAcceso> getHorarios() {
        return horarios;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioAcceso> getHorarioById(@PathVariable Long id) {
        return horarios.stream()
                .filter(h -> h.getId().equals(id))
                .findFirst()
                .map(h -> new ResponseEntity<>(h, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<HorarioAcceso> crearHorario(@RequestBody HorarioAcceso nuevoHorario) {
        nuevoHorario.setId((long) (horarios.size() + 1));
        horarios.add(nuevoHorario);
        return new ResponseEntity<>(nuevoHorario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorarioAcceso> actualizarHorario(@PathVariable Long id, @RequestBody HorarioAcceso horarioActualizado) {
        for (int i = 0; i < horarios.size(); i++) {
            HorarioAcceso h = horarios.get(i);
            if (h.getId().equals(id)) {
                horarioActualizado.setId(id);
                horarios.set(i, horarioActualizado);
                return new ResponseEntity<>(horarioActualizado, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHorario(@PathVariable Long id) {
        boolean removed = horarios.removeIf(h -> h.getId().equals(id));
        if (removed) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/ejemplo")
    public ResponseEntity<HorarioAcceso> crearHorarioEjemplo() {
        HorarioAcceso ejemplo = new HorarioAcceso(
                (long) (horarios.size() + 1),
                "Cliente de ejemplo",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(2)
        );
        horarios.add(ejemplo);
        return new ResponseEntity<>(ejemplo, HttpStatus.CREATED);
    }
}
