package com.example.pw_api_u3_p4_lo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pw_api_u3_p4_lo.repository.modelo.Horario;
import com.example.pw_api_u3_p4_lo.service.IHorarioService;

@RestController
@RequestMapping("/horarios")
public class HorarioControlllerRestFul {

    @Autowired
    private IHorarioService horarioService;

    @GetMapping
    public List<Horario> consultarTodos() {
        return this.horarioService.buscarTodos();
    }

    @GetMapping(path = "/{diaSemana}")
    public Horario consultarPorDiaSemana(@PathVariable String diaSemana) {
        return this.horarioService.consultarPorDiaSemana(diaSemana);
    }

    @PostMapping
    public void guardar(@RequestBody Horario horario) {
        this.horarioService.guardar(horario);
    }

    @PutMapping(path = "/{identificador}")
    public void actualizar(@RequestBody Horario horario, @PathVariable Integer identificador) {
        horario.setId(identificador);
        this.horarioService.actualizar(horario);
    }

    @PatchMapping(path = "/{identificador}")
    public void actualizarParcial(@RequestBody Horario horario, @PathVariable Integer identificador) {
        horario.setId(identificador);
        String diaSemana = "Jueves";
        Horario hora1 = this.horarioService.consultarPorDiaSemana(diaSemana);
        hora1.setDiaSemana(horario.getDiaSemana());
        this.horarioService.actualizarParcial(hora1);
    }

    @DeleteMapping(path = "/{id}")
    public void eliminar(@PathVariable Integer id) {
        this.horarioService.eliminar(id);
    }

}
