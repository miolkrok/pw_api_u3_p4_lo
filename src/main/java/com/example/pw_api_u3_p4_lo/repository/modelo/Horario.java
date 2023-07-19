package com.example.pw_api_u3_p4_lo.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "horario")
public class Horario {

    @Id
    @Column(name = "hora_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_generator")
    @SequenceGenerator(name = "name_generator", sequenceName = "hora_id_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "hora_materia")
    private String materia;
    @Column(name = "hora_dia_semana")
    private String diaSemana;
    @Column(name = "hora_horas_diarias")
    private String horasDiarias;
    @Column(name = "hora_aula")
    private String aula;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHorasDiarias() {
        return horasDiarias;
    }

    public void setHorasDiarias(String horasDiarias) {
        this.horasDiarias = horasDiarias;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    @Override
    public String toString() {
        return "Horario [id=" + id + ", materia=" + materia + ", diaSemana=" + diaSemana + ", horasDiarias="
                + horasDiarias + ", aula=" + aula + "]";
    }

}
