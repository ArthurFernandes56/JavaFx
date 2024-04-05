/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author kakas
 */
public class Ingresso {
    String Nome;
    String ingresso;
    int idade;
    double preco;

    public Ingresso() {
    }

    public Ingresso(String Nome, int idade,  String ingresso,  double preco) {
        this.Nome = Nome;
        this.ingresso = ingresso;
        this.idade = idade;
        this.preco = preco;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCadeira() {
        return ingresso;
    }

    public void setCadeira(String ingresso) {
        this.ingresso = ingresso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return Nome +  ", idade:" + idade + ", ingresso:" + ingresso + ", Total:" + preco + '}';
    }


    
}
