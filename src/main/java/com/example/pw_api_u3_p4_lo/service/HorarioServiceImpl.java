package com.example.pw_api_u3_p4_lo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pw_api_u3_p4_lo.repository.IHorarioRepository;
import com.example.pw_api_u3_p4_lo.repository.modelo.Horario;

import javax.transaction.Transactional;

@Service
@Transactional
public class HorarioServiceImpl implements IHorarioService {

    @Autowired
    private IHorarioRepository horarioRepo;

    @Override
    public List<Horario> buscarTodos() {
        return this.horarioRepo.buscarTodos();
    }

    @Override
    public Horario consultarPorDiaSemana(String diaSemana) {
        return this.horarioRepo.consultarPorDiaSemana(diaSemana);
    }

    @Override
    public void guardar(Horario horario) {
        this.horarioRepo.insertar(horario);
    }

    @Override
    public void actualizar(Horario horario) {
        this.horarioRepo.actualizar(horario);
    }

    @Override
    public void actualizarParcial(Horario horario) {
        this.horarioRepo.actualizarParcial(horario);
    }

    @Override
    public void eliminar(Integer id) {
        this.horarioRepo.borrar(id);
    }

    @Override
    public Horario buscarPorIdHorario(Integer id) {
        return this.horarioRepo.buscarPorIdHorario(id);
    }

}
