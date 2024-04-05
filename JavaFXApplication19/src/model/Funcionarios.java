/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author kakas
 */
public class Funcionarios {
    
    String nome;
    Integer numDependentes;
    Double salario;

    public Funcionarios() {
    }

    public Funcionarios(String nome, Integer numDependentes, Double salario) {
        this.nome = nome;
        this.numDependentes = numDependentes;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumDependentes() {
        return numDependentes;
    }

    public void setNumDependentes(Integer numDependentes) {
        this.numDependentes = numDependentes;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionarios{" + "nome=" + nome + ", numDependentes=" + numDependentes + ", salario=" + salario + '}';
    }
    
}
