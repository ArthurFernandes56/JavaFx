/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cfi028_provab_8813;

/**
 *
 * @author Aluno
 */
public class compras {
    String nome; 
    int idade;
    String texto;
    Double preco; 

    public compras(String nome, int idade, String texto, Double preco) {
        this.nome = nome;
        this.idade = idade;
        this.texto = texto;
        this.preco = preco;
    }

    public compras() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
