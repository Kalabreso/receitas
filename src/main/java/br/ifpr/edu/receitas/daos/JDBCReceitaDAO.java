package br.ifpr.edu.receitas.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ifpr.edu.receitas.daos.interfaces.ReceitaDAO;
import br.ifpr.edu.receitas.models.Receita;
import br.ifpr.edu.receitas.models.Usuario;
import br.ifpr.edu.receitas.repositories.RepositorioUsuario;
import br.ifpr.edu.receitas.utils.FabricaDeConexoes;
import br.ifpr.edu.receitas.utils.VariavelGlobalUsuario;

public class JDBCReceitaDAO implements ReceitaDAO{

    @Override
    public boolean cadastrar(Receita receita) throws SQLException {
        Connection conn = FabricaDeConexoes.getConnection();

        String sql = "INSERT INTO receita(nome, ingredientes, descricao, usuario_id) VALUES (?, ?, ?, ?)";
        
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, receita.getNome());
        pstmt.setString(2, receita.getIngredientes());
        pstmt.setString(3, receita.getDescricao());
        pstmt.setInt(4, receita.getUsuario().getId());

        int flag = pstmt.executeUpdate();

        conn.close();
        pstmt.close();

        return flag == 1;
    }

    @Override
    public ArrayList<Receita> listar() throws SQLException {
        Connection conn = FabricaDeConexoes.getConnection();
        RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
        ArrayList<Receita> receitas = new ArrayList<>();

        String sql = "SELECT * FROM receita WHERE ativo = 1";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();

        while(rs.next()) {
            int id = rs.getInt( "id");
            String nome = rs.getString("nome");
            String ingredientes = rs.getString("ingredientes");
            String descricao = rs.getString("descricao");
            Usuario usuario = repositorioUsuario.buscarUsuarioPorId(rs.getInt("usuario_id"));

            Receita r = new Receita(id, nome, ingredientes, descricao, usuario);
            receitas.add(r);
        }

        rs.close();
        pstmt.close();
        conn.close();

        return receitas;
    }

    @Override
    public boolean atualizar(Receita receita) throws SQLException {
        Connection conn = FabricaDeConexoes.getConnection();

        String sql = "UPDATE receita SET nome = ?, ingredientes = ?, descricao = ? WHERE id = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, receita.getNome());
        pstmt.setString(2, receita.getIngredientes());
        pstmt.setString(3, receita.getDescricao());
        pstmt.setInt(4, receita.getId());

        boolean flag = pstmt.executeUpdate() == 1;

        pstmt.close();
        conn.close();

        return flag;
    }

    @Override
    public boolean remover(Receita receita) throws SQLException {
        Connection conn = FabricaDeConexoes.getConnection();

        String sql = "UPDATE receita SET ativo = 0 WHERE id = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, receita.getId());

        boolean flag = pstmt.executeUpdate() == 1;

        pstmt.close();
        conn.close();

        return flag;
    }

    @Override
    public ArrayList<Receita> listarReceitasUsuario() throws SQLException {
        Connection conn = FabricaDeConexoes.getConnection();
        ArrayList<Receita> receitas = new ArrayList<>();
        Usuario u = VariavelGlobalUsuario.getUsuario();

        String sql = "SELECT * FROM receita WHERE usuario_id = ? AND ativo = 1";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, u.getId());

        ResultSet rs = pstmt.executeQuery();

        while(rs.next()) {
            int id = rs.getInt( "id");
            String nome = rs.getString("nome");
            String ingredientes = rs.getString("ingredientes");
            String descricao = rs.getString("descricao");
            Usuario usuario = u;

            Receita r = new Receita(id, nome, ingredientes, descricao, usuario);
            receitas.add(r);
        }

        rs.close();
        pstmt.close();
        conn.close();

        return receitas;
    }
    
}
