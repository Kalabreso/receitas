package br.ifpr.edu.receitas.repositories;

import java.sql.SQLException;
import java.util.ArrayList;

import br.ifpr.edu.receitas.daos.JDBCIngredienteDAO;
import br.ifpr.edu.receitas.daos.interfaces.IngredienteDAO;
import br.ifpr.edu.receitas.models.Ingrediente;

public class RepositorioIngrediente {
    
    private IngredienteDAO ingredienteDAO;

    public RepositorioIngrediente(){
        this.ingredienteDAO = new JDBCIngredienteDAO();
    }

    public boolean cadastrarIngrediente(String nomeIngrediente){
        Ingrediente ingrediente = new Ingrediente(0, nomeIngrediente);

        try {
            return ingredienteDAO.cadastrar(ingrediente);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar Ingrediente no banco!", e);
        }
    }

    public ArrayList<Ingrediente> listarIngredientes(){
        try {
            return ingredienteDAO.listar();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Ingredientes no banco!", e);
        }
    }

    public boolean atualizarIngrediente(int receita_id, int ingrediente_id, String nome, String medida, int quantidade){
        Ingrediente ingrediente = new Ingrediente(ingrediente_id, nome, medida, quantidade);

        try {
            return ingredienteDAO.atualizar(ingrediente, receita_id);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar Ingrediente no banco!", e);
        }
    }

    public boolean removerIngrediente(int receita_id, int ingrediente_id){
        try {
            return ingredienteDAO.remover(receita_id, ingrediente_id);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover Ingrediente da receita no banco!", e);
        }
    }

    public ArrayList<Ingrediente> retornarIngredientesReceita(int receita_id){
        try {
            return ingredienteDAO.retornarIngredientesReceita(receita_id);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Ingrediente no banco de uma determinada receita!", e);
        }
    }
    public boolean cadastrarIngredienteReceita(int receita_id, int ingrediente_id, String medida, int quantidade){
        try {
            return ingredienteDAO.cadastrarIngredienteReceita(receita_id, ingrediente_id, medida, quantidade);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar Ingrediente no banco em uma determinada receita!", e);
        }
    }
}
