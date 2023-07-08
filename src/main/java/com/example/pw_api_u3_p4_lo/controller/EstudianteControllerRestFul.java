package com.example.pw_api_u3_p4_lo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pw_api_u3_p4_lo.repository.modelo.Estudiante;
import com.example.pw_api_u3_p4_lo.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {

    @Autowired
    private IEstudianteService estudianteService;

    //GET
    @GetMapping(path = "/buscar")
    public Estudiante consultarPorCedula(){
        String cedula = "1718496944";
        return this.estudianteService.consultarPorCedula(cedula);
    }
    
}
