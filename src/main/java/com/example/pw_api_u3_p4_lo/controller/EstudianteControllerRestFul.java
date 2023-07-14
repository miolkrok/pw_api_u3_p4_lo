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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pw_api_u3_p4_lo.repository.modelo.Estudiante;
import com.example.pw_api_u3_p4_lo.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {

    @Autowired
    private IEstudianteService estudianteService;

    // GET
    @GetMapping(path = "/buscar/{cedula}")
    public Estudiante consultarPorCedula(@PathVariable String cedula) {
        return this.estudianteService.consultarPorCedula(cedula);
    }

    @PostMapping(path = "/guardar")
    public void guardar(@RequestBody Estudiante estudiante) {
        this.estudianteService.guardar(estudiante);
    }

    @PutMapping(path = "/actualizar/{identificador}")
    public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
        estudiante.setId(identificador);
        this.estudianteService.actualizar(estudiante);
    }

    @PatchMapping(path = "/actualizarParcial/{identificador}")
    public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
        estudiante.setId(identificador);
        String cedula = "1718496945";
        Estudiante estu1 = this.estudianteService.consultarPorCedula(cedula);
        estu1.setCedula(estudiante.getCedula());
        this.estudianteService.actualizar(estu1);
    }

    @PatchMapping(path = "/actualizarParcialB/{identificador}")
    public void actualizarParcialb(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
        estudiante.setId(identificador);
        String cedula = "1718496945";
        Estudiante estu1 = this.estudianteService.consultarPorCedula(cedula);
        estu1.setCedula(estudiante.getCedula());
        this.estudianteService.actualizar(estu1);
    }

    @DeleteMapping(path = "/borrar/{id}")
    public void borrar(@PathVariable Integer id) {
        this.estudianteService.eliminar(id);
    }

    @GetMapping(path = "/buscarTodos")
    public List<Estudiante> consultarTodos(@RequestParam String provincia){
        String prov = "Pichincha";
        return this.estudianteService.buscarTodos(prov);
    }
}
