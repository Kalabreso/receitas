package br.ifpr.edu.receitas.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ifpr.edu.receitas.daos.interfaces.UsuarioDAO;
import br.ifpr.edu.receitas.models.Usuario;
import br.ifpr.edu.receitas.utils.FabricaDeConexoes;

public class JDBCUsuarioDao implements UsuarioDAO{

    @Override
    public boolean cadastrar(Usuario usuario) throws SQLException {
        Connection conn = FabricaDeConexoes.getConnection();

        String sql = "INSERT INTO usuario(nome, email, senha) VALUES (?, ?, ?)";
        
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, usuario.getNome());
        pstmt.setString(2, usuario.getEmail());
        pstmt.setString(3, usuario.getSenha());

        int flag = pstmt.executeUpdate();

        conn.close();
        pstmt.close();

        return flag == 1;
    }

    @Override
    public ArrayList<Usuario> listar() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }

    @Override
    public boolean atualizar(Usuario usuario) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public boolean remover(Usuario usuario) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }
    
}
