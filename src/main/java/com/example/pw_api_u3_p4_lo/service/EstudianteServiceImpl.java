package com.example.pw_api_u3_p4_lo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import com.example.pw_api_u3_p4_lo.repository.IEstudianteRepository;
import com.example.pw_api_u3_p4_lo.repository.modelo.Estudiante;

@Service
@Transactional
public class EstudianteServiceImpl implements IEstudianteService {

    @Autowired
    private IEstudianteRepository estuRepo;

    @Override
    public Estudiante consultarPorCedula(String cedula) {
        return this.estuRepo.consultarPorCedula(cedula);

    }

    @Override
    public void guardar(Estudiante estudiante) {

        this.estuRepo.insertar(estudiante);
    }

}
