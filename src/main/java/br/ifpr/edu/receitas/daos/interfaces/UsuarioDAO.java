package br.ifpr.edu.receitas.daos.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import br.ifpr.edu.receitas.models.Usuario;

public interface UsuarioDAO {
    boolean cadastrar(Usuario usuario) throws SQLException;
    ArrayList<Usuario> listar() throws SQLException;
    boolean atualizar(Usuario usuario) throws SQLException;
    boolean remover(Usuario usuario) throws SQLException;
    Usuario buscarUsuario(String email, String senha) throws SQLException;
    Usuario buscarUsuarioId(int idUsuario) throws SQLException;
}
