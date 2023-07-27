package com.example.pw_api_u3_p4_lo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import com.example.pw_api_u3_p4_lo.repository.IEstudianteRepository;
import com.example.pw_api_u3_p4_lo.repository.modelo.Estudiante;
import com.example.pw_api_u3_p4_lo.service.to.EstudianteTO;

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

    @Override
    public void actualizar(Estudiante estudiante) {
        this.estuRepo.actualizar(estudiante);
    }

    @Override
    public void actualizarParcial(Estudiante estudiante) {
        this.estuRepo.actualizarParcial(estudiante);
    }

    @Override
    public void actualizarParcialB(String cedulaOri, String cedulaNueva) {
       this.estuRepo.actualizarParcialB(cedulaOri, cedulaNueva);
    }

    @Override
    public void eliminar(Integer id) {
        this.estuRepo.borrar(id);
    }

    @Override
    public Estudiante buscarPorIdEstudiante(Integer id) {
        return this.estuRepo.buscarPorIdEstudiante(id);
    }

    @Override
    public List<Estudiante> buscarTodosProv(String provincia) {
        return this.estuRepo.buscarTodosProv(provincia);
    }

    @Override
    public List<Estudiante> buscarTodos() {
         return this.estuRepo.buscarTodos();
    }

    @Override
    public List<EstudianteTO> buscarTodosTO() {
        List<Estudiante> lista = this.estuRepo.buscarTodos();
        List<EstudianteTO> listaTO = lista.stream().map(estudiante->this.convertir(estudiante)).collect(Collectors.toList());
        return listaTO;
    }

    private EstudianteTO convertir(Estudiante estudiante){
        EstudianteTO est= new EstudianteTO();
        est.setId(estudiante.getId());
        est.setApellido(estudiante.getApellido());
        est.setCedula(estudiante.getCedula());
        est.setFechaNacimiento(estudiante.getFechaNacimiento());
        est.setNombre(estudiante.getNombre());
        est.setProvincia(estudiante.getProvincia());
        return est;
    }
}
