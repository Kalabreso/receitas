package br.ifpr.edu.receitas.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        Connection conn = FabricaDeConexoes.getConnection();

        String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ? WHERE id = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, usuario.getNome());
        pstmt.setString(2, usuario.getEmail());
        pstmt.setString(3, usuario.getSenha());
        pstmt.setInt(4, usuario.getId());

        boolean flag = pstmt.executeUpdate() == 1;

        pstmt.close();
        conn.close();

        return flag;
    }

    @Override
    public boolean remover(Usuario usuario) throws SQLException {
        Connection conn = FabricaDeConexoes.getConnection();

        String sql = "UPDATE usuario SET ativo = 0 WHERE id = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, usuario.getId());

        boolean flag = pstmt.executeUpdate() == 1;

        pstmt.close();
        conn.close();

        return flag;
    }

    @Override
    public Usuario buscarUsuario(String email, String senha) throws SQLException {
        Connection conn = FabricaDeConexoes.getConnection();
        Usuario usuario = null;

        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ? AND ativo = 1";
        
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, email);
        pstmt.setString(2, senha);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            int usuarioId = rs.getInt("id");
            String usuarioNome = rs.getString("nome");
            String usuarioEmail = rs.getString("email");
            String usuarioSenha = rs.getString("senha");

            usuario = new Usuario(usuarioId, usuarioNome, usuarioEmail, usuarioSenha);          
        }

        conn.close();
        pstmt.close();
        rs.close();

        return usuario;
    }

    @Override
    public Usuario buscarUsuarioId(int idUsuario) throws SQLException {
        Connection conn = FabricaDeConexoes.getConnection();
        Usuario usuario = null;

        String sql = "SELECT * FROM usuario WHERE id = ?";
        
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, idUsuario);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            int usuarioId = rs.getInt("id");
            String usuarioNome = rs.getString("nome");
            String usuarioEmail = rs.getString("email");
            String usuarioSenha = rs.getString("senha");

            usuario = new Usuario(usuarioId, usuarioNome, usuarioEmail, usuarioSenha);          
        }

        conn.close();
        pstmt.close();
        rs.close();

        return usuario;
    }
}
