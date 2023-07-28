package com.example.pw_api_u3_p4_lo.service;

import java.util.List;

import com.example.pw_api_u3_p4_lo.repository.modelo.Materia;
import com.example.pw_api_u3_p4_lo.service.to.MateriaTO;

public interface IMateriaService {

    public void guardar(Materia materia);

    public Materia consultarMateria(String nombre);

    public List<MateriaTO> buscarPorCedulaEstudiante(String cedula);

    public MateriaTO buscarPorId(Integer id);
}
