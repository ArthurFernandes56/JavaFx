/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author kakas
 */
public class Faltas {
    Integer matricula;
    String codDisciplina;
    Integer faltas;

    public Faltas() {
    }

    public Faltas(Integer matricula, String codDisciplina, Integer faltas) {
        this.matricula = matricula;
        this.codDisciplina = codDisciplina;
        this.faltas = faltas;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(String codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }

    @Override
    public String toString() {
        return "Faltas{" + "matricula=" + matricula + ", codDisciplina=" + codDisciplina + ", faltas=" + faltas + '}';
    }
    
    

}