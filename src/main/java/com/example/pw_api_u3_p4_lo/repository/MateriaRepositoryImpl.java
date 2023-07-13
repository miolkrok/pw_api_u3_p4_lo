package com.example.pw_api_u3_p4_lo.repository;

import org.springframework.stereotype.Repository;

import com.example.pw_api_u3_p4_lo.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


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
    
}
