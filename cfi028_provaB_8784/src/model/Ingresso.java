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
    String nome;
    String texto;
    Integer idade;
    Double preco;

    public Ingresso() {
    }

    public Ingresso(String nome, String texto, Integer idade, Double preco) {
        this.nome = nome;
        this.texto = texto;
        this.idade = idade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Cliente: "+nome+  ", idade:" + idade + ", Total:" + preco+ "\nComprou: "+texto;
    }
    
    

    }
