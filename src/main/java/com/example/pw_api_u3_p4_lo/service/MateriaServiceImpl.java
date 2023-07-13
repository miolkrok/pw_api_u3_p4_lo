package com.example.pw_api_u3_p4_lo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pw_api_u3_p4_lo.repository.IMateriaRepository;
import com.example.pw_api_u3_p4_lo.repository.modelo.Materia;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MateriaServiceImpl implements IMateriaService {

    @Autowired
    private IMateriaRepository materiaRepo;

    @Override
    public void guardar(Materia materia) {
        this.materiaRepo.insertar(materia);
    }

    @Override
    public Materia consultarMateria(String nombre) {
        return this.materiaRepo.consultarMateria(nombre);

    }

}
