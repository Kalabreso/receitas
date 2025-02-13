package br.ifpr.edu.receitas.repositories;

import java.sql.SQLException;
import java.util.ArrayList;

import br.ifpr.edu.receitas.daos.JDBCReceitaDAO;
import br.ifpr.edu.receitas.daos.interfaces.ReceitaDAO;
import br.ifpr.edu.receitas.models.Receita;
import br.ifpr.edu.receitas.models.Usuario;

public class RepositorioReceita {
    
    private ReceitaDAO receitaDAO;

    public RepositorioReceita(){
        this.receitaDAO = new JDBCReceitaDAO();
    }

    public boolean cadastrarReceita(String nome, String descricao, Usuario usuario){
        Receita receita = new Receita(0, nome, new ArrayList<>(), descricao, usuario);

        try {
            return receitaDAO.cadastrar(receita);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar Receita no banco!", e);
        }
    }

    public ArrayList<Receita> listarReceitas(){
        try {
            return receitaDAO.listar();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Receitas no banco!", e);
        }
    }

    public boolean atualizarReceita(Receita receita){
        try {
            return receitaDAO.atualizar(receita);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar Receita no banco!", e);
        }
    }

    public boolean removerReceita(Receita receita){
        try {
            return receitaDAO.remover(receita);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover Receita no banco!", e);
        }
    }

    public ArrayList<Receita> listarReceitasUsuario(){
        try {
            return receitaDAO.listarReceitasUsuario();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Receitas do usuário no banco!", e);
        }
    }
}
