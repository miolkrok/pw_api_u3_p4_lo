package com.example.pw_api_u3_p4_lo.repository;

import java.util.List;

import com.example.pw_api_u3_p4_lo.repository.modelo.Horario;

public interface IHorarioRepository {

    public List<Horario> buscarTodos();

    public Horario consultarPorDiaSemana(String diaSemana);

    public void insertar(Horario horario);

    public void actualizar(Horario horario);

    public void actualizarParcial(Horario horario);

    public void borrar(Integer id);

    public Horario buscarPorIdHorario(Integer id);

}
