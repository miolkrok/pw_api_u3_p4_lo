package com.example.pw_api_u3_p4_lo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pw_api_u3_p4_lo.repository.modelo.Materia;
import com.example.pw_api_u3_p4_lo.service.IMateriaService;
import com.example.pw_api_u3_p4_lo.service.to.MateriaTO;

@RestController
@RequestMapping("/materias")
public class MateriaControllerRestFul {

    @Autowired
    private IMateriaService materiaService;

    @GetMapping(path = "/buscar")
    public Materia consultarPorMateria() {
        String nombre = "programacion web";
        return this.materiaService.consultarMateria(nombre);
    }

    @PostMapping(path = "/guardar")
    public void guardar(@RequestBody Materia materia) {
        this.materiaService.guardar(materia);
    }

    @GetMapping(path = "/{identificador}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MateriaTO> consultarPorId(@PathVariable Integer identificador){
        MateriaTO matTo = this.materiaService.buscarPorId(identificador);
        return new ResponseEntity<>(matTo, null, 200); 
    }

}
