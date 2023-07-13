package com.example.pw_api_u3_p4_lo.service;

import com.example.pw_api_u3_p4_lo.repository.modelo.Materia;

public interface IMateriaService {
    
    public void guardar(Materia materia);

    public Materia consultarMateria(String nombre);
}
