package br.ifpr.edu.receitas.models;

public class Receita {
    
    private int id;
    private String nome;
    private String ingredientes;
    private String descricao;
    private Usuario usuario;

    public Receita(int id, String nome, String ingredientes, String descricao, Usuario usuario) {
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

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
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
}
