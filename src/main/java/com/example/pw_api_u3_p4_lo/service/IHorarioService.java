package com.example.pw_api_u3_p4_lo.service;

import java.util.List;

import com.example.pw_api_u3_p4_lo.repository.modelo.Horario;

public interface IHorarioService {

    public List<Horario> buscarTodos();

    public Horario consultarPorDiaSemana(String diaSemana);

    public void guardar(Horario horario);

    public void actualizar(Horario horario);

    public void actualizarParcial(Horario horario);

    public void eliminar(Integer id);

    public Horario buscarPorIdHorario(Integer id);

}
