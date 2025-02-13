package br.ifpr.edu.receitas.daos.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import br.ifpr.edu.receitas.models.Ingrediente;

public interface IngredienteDAO {
    boolean cadastrar(Ingrediente ingrediente) throws SQLException;
    ArrayList<Ingrediente> listar() throws SQLException;
    boolean atualizar(Ingrediente ingrediente, int receita_id) throws SQLException;
    boolean remover(int receita_id, int ingrediente_id) throws SQLException;
    ArrayList<Ingrediente> retornarIngredientesReceita(int receita_id) throws SQLException;
    boolean cadastrarIngredienteReceita(int receita_id, int ingrediente_id, String medida, int quantidade) throws SQLException;
}
