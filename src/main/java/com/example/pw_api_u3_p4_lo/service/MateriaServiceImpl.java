package com.example.pw_api_u3_p4_lo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pw_api_u3_p4_lo.repository.IMateriaRepository;
import com.example.pw_api_u3_p4_lo.repository.modelo.Materia;
import com.example.pw_api_u3_p4_lo.service.to.MateriaTO;

import javax.transaction.Transactional;

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

    @Override
    public List<MateriaTO> buscarPorCedulaEstudiante(String cedula) {
        List<Materia> lista = this.materiaRepo.buscarPorCedulaEstudiante(cedula);
        List<MateriaTO> listaTO = lista.stream().map(materia -> this.convertir(materia)).collect(Collectors.toList());
        return listaTO;
    }

    @Override
    public MateriaTO buscarPorId(Integer id) {
        return convertir(this.materiaRepo.buscarPorId(id));

    }

    private MateriaTO convertir(Materia materia) {
        MateriaTO mat = new MateriaTO();
        mat.setId(materia.getId());
        mat.setNombreMateria(materia.getNombreMateria());
        mat.setNumeroCredito(materia.getNumeroCredito());
        return mat;
    }

}
