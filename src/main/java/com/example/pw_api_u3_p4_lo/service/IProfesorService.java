package com.example.pw_api_u3_p4_lo.service;

import java.util.List;

import com.example.pw_api_u3_p4_lo.repository.modelo.Profesor;

public interface IProfesorService {

    public List<Profesor> buscarTodos();

    public Profesor consultarPorCedula(String cedula);

    public void guardar(Profesor profesor);

    public void actualizar(Profesor profesor);

    public void actualizarParcial(Profesor profesor);

    public void eliminar(Integer id);

    public Profesor buscarPorIdProfesor(Integer id);
}
