package com.example.pw_api_u3_p4_lo.service;

import com.example.pw_api_u3_p4_lo.repository.modelo.Estudiante;

public interface IEstudianteService {
    public void guardar(Estudiante estudiante);
    public Estudiante consultarPorCedula(String cedula);
    
    
}
