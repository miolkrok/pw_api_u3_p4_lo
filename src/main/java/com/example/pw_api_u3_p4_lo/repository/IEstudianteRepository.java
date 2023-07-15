package com.example.pw_api_u3_p4_lo.repository;

import java.util.List;

import com.example.pw_api_u3_p4_lo.repository.modelo.Estudiante;

public interface IEstudianteRepository {
    public void insertar(Estudiante estudiante);
    public Estudiante consultarPorCedula(String cedula);
    public void actualizar(Estudiante estudiante);
    public void actualizarParcial(Estudiante estudiante);
    public void actualizarParcialB(String cedulaOri , String cedulaNueva);
    public void borrar(Integer id);
    public Estudiante buscarPorIdEstudiante(Integer id);
    public List<Estudiante> buscarTodos();

    public List<Estudiante> buscarTodosProv(String provincia);
}
