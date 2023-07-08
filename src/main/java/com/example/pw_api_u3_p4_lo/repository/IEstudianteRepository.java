package com.example.pw_api_u3_p4_lo.repository;

import com.example.pw_api_u3_p4_lo.repository.modelo.Estudiante;

public interface IEstudianteRepository {
    public Estudiante consultarPorCedula(String cedula);
}
