package br.ifpr.edu.receitas.daos.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import br.ifpr.edu.receitas.models.Receita;

public interface ReceitaDAO {
    boolean cadastrar(Receita receita) throws SQLException;
    ArrayList<Receita> listar() throws SQLException;
    boolean atualizar(Receita receita) throws SQLException;
    boolean remover(Receita receita) throws SQLException;
}
