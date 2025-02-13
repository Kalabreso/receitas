package br.ifpr.edu.receitas.models;

public class Ingrediente {
    
    private int id;
    private String nome;
    private String medida;
    private int quantidade;
    
    public Ingrediente(int id, String nome, String medida, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.medida = medida;
        this.quantidade = quantidade;
    }

    public Ingrediente(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String toString(){
        return nome;
    }
}
