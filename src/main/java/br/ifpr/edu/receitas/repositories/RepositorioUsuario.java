package br.ifpr.edu.receitas.repositories;

import java.sql.SQLException;

import br.ifpr.edu.receitas.daos.JDBCUsuarioDao;
import br.ifpr.edu.receitas.daos.interfaces.UsuarioDAO;
import br.ifpr.edu.receitas.models.Usuario;

public class RepositorioUsuario {
    
    private UsuarioDAO usuarioDAO;

    public RepositorioUsuario(){
        this.usuarioDAO = new JDBCUsuarioDao();
    }

    public boolean cadastrarUsuario(String nome, String email, String senha){
        Usuario usuario = new Usuario(0, nome, email, senha);

        try {
            return usuarioDAO.cadastrar(usuario);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar Usuário no banco!", e);
        }

    }
}
