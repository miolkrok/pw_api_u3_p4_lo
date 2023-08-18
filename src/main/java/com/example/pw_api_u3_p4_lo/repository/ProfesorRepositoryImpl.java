package com.example.pw_api_u3_p4_lo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.pw_api_u3_p4_lo.repository.modelo.Profesor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ProfesorRepositoryImpl implements IProfesorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Profesor> buscarTodos() {
        TypedQuery<Profesor> myQuery = this.entityManager
                .createQuery("SELECT p FROM Profesor p", Profesor.class);

        return myQuery.getResultList();
    }

    @Override
    public Profesor consultarPorCedula(String cedula) {
        TypedQuery<Profesor> myQuery = this.entityManager
                .createQuery("SELECT p FROM Profesor p WHERE p.cedula = :datoCedula", Profesor.class);
        myQuery.setParameter("datoCedula", cedula);
        return myQuery.getSingleResult();
    }

    @Override
    public void insertar(Profesor profesor) {
        this.entityManager.persist(profesor);
    }

    @Override
    public void actualizar(Profesor profesor) {
        this.entityManager.merge(profesor);
    }

    @Override
    public void actualizarParcial(Profesor profesor) {
        this.entityManager.merge(profesor);
    }

    @Override
    public void borrar(Integer id) {
        Profesor profe = this.buscarPorIdProfesor(id);
        this.entityManager.remove(profe);
    }

    @Override
    public Profesor buscarPorIdProfesor(Integer id) {
        return this.entityManager.find(Profesor.class, id);
    }

}
