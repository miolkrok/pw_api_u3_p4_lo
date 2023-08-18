package com.example.pw_api_u3_p4_lo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.pw_api_u3_p4_lo.repository.modelo.Horario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Repository
@Transactional
public class HorarioRepositoryImpl implements IHorarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Horario> buscarTodos() {

        TypedQuery<Horario> myQuery = this.entityManager
                .createQuery("SELECT h FROM Horario h", Horario.class);

        return myQuery.getResultList();

    }

    @Override
    public Horario consultarPorDiaSemana(String diaSemana) {

        TypedQuery<Horario> myQuery = this.entityManager
                .createQuery("SELECT h FROM Horario h WHERE h.diaSemana = :datoDiaSemana", Horario.class);
        myQuery.setParameter("datoDiaSemana", diaSemana);
        return myQuery.getSingleResult();
    }

    @Override
    public void insertar(Horario horario) {
        this.entityManager.persist(horario);
    }

    @Override
    public void actualizar(Horario horario) {
        this.entityManager.merge(horario);
    }

    @Override
    public void actualizarParcial(Horario horario) {
        this.entityManager.merge(horario);
    }

    @Override
    public void borrar(Integer id) {
        Horario hora = this.buscarPorIdHorario(id);
        this.entityManager.remove(hora);
    }

    @Override
    public Horario buscarPorIdHorario(Integer id) {
        return this.entityManager.find(Horario.class, id);
    }

}
