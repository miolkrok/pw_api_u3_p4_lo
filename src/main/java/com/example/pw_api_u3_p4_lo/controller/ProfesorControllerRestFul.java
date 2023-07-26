package com.example.pw_api_u3_p4_lo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.pw_api_u3_p4_lo.repository.modelo.Profesor;
import com.example.pw_api_u3_p4_lo.service.IProfesorService;

@RestController
@RequestMapping("/profesores")
public class ProfesorControllerRestFul {

    @Autowired
    private IProfesorService profesorService;

    @GetMapping(path = "/{cedula}", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Profesor consultarPorCedula(@PathVariable String cedula) {
        return this.profesorService.consultarPorCedula(cedula);
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Profesor> consultarTodos() {
        return this.profesorService.buscarTodos();
    }

    @PostMapping(consumes = "application/xml")
    @ResponseStatus(HttpStatus.OK)
    public void guardar(@RequestBody Profesor profesor) {
        this.profesorService.guardar(profesor);
    }

    @PutMapping(path = "/{identificador}", consumes = "application/xml")
    @ResponseStatus(HttpStatus.OK)
    public void actualizar(@RequestBody Profesor profesor, @PathVariable Integer identificador) {
        profesor.setId(identificador);
        this.profesorService.actualizar(profesor);
    }

    @PatchMapping(path = "/{identificador}", consumes = "application/xml")
    @ResponseStatus(HttpStatus.OK)
    public void actualizarParcial(@RequestBody Profesor profesor, @PathVariable Integer identificador) {
        profesor.setId(identificador);
        String cedula = "1798548652";
        Profesor prof1 = this.profesorService.consultarPorCedula(cedula);
        prof1.setCedula(profesor.getCedula());
        this.profesorService.actualizarParcial(prof1);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void borrar(@PathVariable Integer id) {
        this.profesorService.eliminar(id);
    }
}
