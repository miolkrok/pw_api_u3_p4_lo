package com.example.pw_api_u3_p4_lo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pw_api_u3_p4_lo.repository.IProfesorRepository;
import com.example.pw_api_u3_p4_lo.repository.modelo.Profesor;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProfesorServiceImpl implements IProfesorService {

    @Autowired
    private IProfesorRepository profesorRepo;

    @Override
    public List<Profesor> buscarTodos() {
        return this.profesorRepo.buscarTodos();
    }

    @Override
    public Profesor consultarPorCedula(String cedula) {
        return this.profesorRepo.consultarPorCedula(cedula);
    }

    @Override
    public void guardar(Profesor profesor) {
        this.profesorRepo.insertar(profesor);
    }

    @Override
    public void actualizar(Profesor profesor) {
        this.profesorRepo.actualizar(profesor);
    }

    @Override
    public void actualizarParcial(Profesor profesor) {
        this.profesorRepo.actualizarParcial(profesor);
    }

    @Override
    public void eliminar(Integer id) {
        this.profesorRepo.borrar(id);
    }

    @Override
    public Profesor buscarPorIdProfesor(Integer id) {
        return this.profesorRepo.buscarPorIdProfesor(id);
    }

}
