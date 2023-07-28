package com.example.pw_api_u3_p4_lo.repository;

import java.util.List;

import com.example.pw_api_u3_p4_lo.repository.modelo.Materia;

public interface IMateriaRepository {
    public void insertar(Materia materia);
    public Materia consultarMateria(String nombre);
    public List<Materia> buscarPorCedulaEstudiante(String cedula);
    public Materia buscarPorId(Integer id);
    
    
    
}
