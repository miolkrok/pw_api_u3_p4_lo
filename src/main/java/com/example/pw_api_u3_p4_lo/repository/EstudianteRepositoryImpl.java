package com.example.pw_api_u3_p4_lo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.example.pw_api_u3_p4_lo.repository.modelo.Estudiante;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Estudiante consultarPorCedula(String cedula) {

        TypedQuery<Estudiante> myQuery = this.entityManager
                .createQuery("SELECT e FROM Estudiante e WHERE e.cedula = :datoCedula", Estudiante.class);
        myQuery.setParameter("datoCedula", cedula);
        return myQuery.getSingleResult();

    }

    @Override
    public void insertar(Estudiante estudiante) {

        this.entityManager.persist(estudiante);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        this.entityManager.merge(estudiante);
    }

    @Override
    public void actualizarParcial(Estudiante estudiante) {
        this.entityManager.merge(estudiante);
    }

    @Override
    public void actualizarParcialB(String cedulaOri, String cedulaNueva) {
        Query myQuery = this.entityManager
                .createQuery("UPDATE Estudiante e SET e.cedula =:datoCedula WHERE e.cedula =:datoCondicion");
        myQuery.setParameter("datoCedula", cedulaNueva);
        myQuery.setParameter("datoCondicion", cedulaOri);
        myQuery.executeUpdate();
    }

    @Override
    public void borrar(Integer id) {
        Estudiante estu = this.buscarPorIdEstudiante(id);
        this.entityManager.remove(estu);
    }

    public Estudiante buscarPorIdEstudiante(Integer id) {
        return this.entityManager.find(Estudiante.class, id);

    }

    @Override
    public List<Estudiante> buscarTodosProv(String provincia) {
        TypedQuery<Estudiante> myQuery = this.entityManager
                .createQuery("SELECT e FROM Estudiante e WHERE e.provincia =:datoProvincia", Estudiante.class);
        myQuery.setParameter("datoProvincia", provincia);
        return myQuery.getResultList();
    }

    @Override
    public List<Estudiante> buscarTodos() {
        TypedQuery<Estudiante> myQuery = this.entityManager
                .createQuery("SELECT e FROM Estudiante e",Estudiante.class);

        return myQuery.getResultList();
    }

}
