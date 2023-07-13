package com.example.pw_api_u3_p4_lo.repository;

import com.example.pw_api_u3_p4_lo.repository.modelo.Materia;

public interface IMateriaRepository {
    public void insertar(Materia materia);
    public Materia consultarMateria(String nombre);
    
}
