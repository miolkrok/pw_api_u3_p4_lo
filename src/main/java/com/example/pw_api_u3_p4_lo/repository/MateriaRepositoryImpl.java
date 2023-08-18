package com.example.pw_api_u3_p4_lo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.pw_api_u3_p4_lo.repository.modelo.Materia;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;


@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Materia materia) {
        this.entityManager.persist(materia);
    }

    @Override
    public Materia consultarMateria(String nombre) {
        TypedQuery<Materia> myQuery = this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.nombreMateria = :datoNombreMateria", Materia.class);
        myQuery.setParameter("datoNombreMateria",nombre);
        return myQuery.getSingleResult();
    }

    @Override
    public List<Materia> buscarPorCedulaEstudiante(String cedula) {
        TypedQuery<Materia> myQuery = this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.estudiante.cedula = :datoCedula", Materia.class);
        myQuery.setParameter("datoCedula",cedula);
        return myQuery.getResultList();
    }

    @Override
    public Materia buscarPorId(Integer id) {
        return this.entityManager.find(Materia.class, id);
    }
}
