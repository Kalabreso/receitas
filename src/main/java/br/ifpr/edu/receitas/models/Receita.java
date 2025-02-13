package br.ifpr.edu.receitas.models;

import java.util.ArrayList;

public class Receita {
    
    private int id;
    private String nome;
    private ArrayList<Ingrediente> ingredientes;
    private String descricao;
    private Usuario usuario;

    public Receita(int id, String nome, ArrayList<Ingrediente> ingredientes, String descricao, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.descricao = descricao;
        this.usuario = usuario;
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

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String toString(){
        return nome;
    }
}
