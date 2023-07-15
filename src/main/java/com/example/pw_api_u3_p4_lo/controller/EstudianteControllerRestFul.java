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
    @GetMapping(path = "/{cedula}")
    public Estudiante consultarPorCedula(@PathVariable String cedula) {
        return this.estudianteService.consultarPorCedula(cedula);
    }

    //@GetMapping()
    //public List<Estudiante> consultarTodos() {

        //return this.estudianteService.buscarTodos();
    //}

    @GetMapping
    public List<Estudiante> consultarTodosProv(@RequestParam String provincia) {

        return this.estudianteService.buscarTodosProv(provincia);
    }

    @PostMapping
    public void guardar(@RequestBody Estudiante estudiante) {
        this.estudianteService.guardar(estudiante);
    }

    @PutMapping(path = "/{identificador}")
    public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
        estudiante.setId(identificador);
        this.estudianteService.actualizar(estudiante);
    }

    @PatchMapping(path = "/{identificador}")
    public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
        estudiante.setId(identificador);
        String cedula = "1718496945";
        Estudiante estu1 = this.estudianteService.consultarPorCedula(cedula);
        estu1.setCedula(estudiante.getCedula());
        this.estudianteService.actualizarParcial(estu1);
    }


    @DeleteMapping(path = "/{id}")
    public void borrar(@PathVariable Integer id) {
        this.estudianteService.eliminar(id);
    }

}
