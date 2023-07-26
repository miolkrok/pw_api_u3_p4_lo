package com.example.pw_api_u3_p4_lo.repository;

import java.util.List;

import com.example.pw_api_u3_p4_lo.repository.modelo.Profesor;

public interface IProfesorRepository {

    public List<Profesor> buscarTodos();

    public Profesor consultarPorCedula(String cedula);

    public void insertar(Profesor profesor);

    public void actualizar(Profesor profesor);

    public void actualizarParcial(Profesor profesor);

    public void borrar(Integer id);

    public Profesor buscarPorIdProfesor(Integer id);

}
