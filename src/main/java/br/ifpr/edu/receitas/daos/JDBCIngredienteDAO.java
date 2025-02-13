package br.ifpr.edu.receitas.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ifpr.edu.receitas.daos.interfaces.IngredienteDAO;
import br.ifpr.edu.receitas.models.Ingrediente;
import br.ifpr.edu.receitas.utils.FabricaDeConexoes;

public class JDBCIngredienteDAO implements IngredienteDAO{

    @Override
    public boolean cadastrar(Ingrediente ingrediente) throws SQLException {
        Connection conn = FabricaDeConexoes.getConnection();

        String sql = "INSERT INTO ingrediente(nome) VALUES (?)";
        
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, ingrediente.getNome());

        int flag = pstmt.executeUpdate();

        conn.close();
        pstmt.close();

        return flag == 1;
    }

    @Override
    public ArrayList<Ingrediente> listar() throws SQLException {
        Connection conn = FabricaDeConexoes.getConnection();
        ArrayList<Ingrediente> ingredientes = new ArrayList<>();

        String sql = "SELECT * FROM ingrediente";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();

        while(rs.next()) {
            int id = rs.getInt( "id");
            String nome = rs.getString("nome");
            
            Ingrediente i = new Ingrediente(id, nome);
            ingredientes.add(i);
        }

        rs.close();
        pstmt.close();
        conn.close();

        return ingredientes;
    }

    @Override
    public boolean atualizar(Ingrediente ingrediente, int receita_id) throws SQLException {
        Connection conn = FabricaDeConexoes.getConnection();

        String sql = "UPDATE receita_ingrediente SET medida = ?, quantidade = ? WHERE receita_id = ? AND ingrediente_id = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, ingrediente.getMedida());
        pstmt.setInt(2, ingrediente.getQuantidade());
        pstmt.setInt(3, receita_id);
        pstmt.setInt(4, ingrediente.getId());

        boolean flag = pstmt.executeUpdate() == 1;

        pstmt.close();
        conn.close();

        return flag;
    }

    @Override
    public boolean remover(int receita_id, int ingrediente_id) throws SQLException {
        Connection conn = FabricaDeConexoes.getConnection();

        String sql = "UPDATE receita_ingrediente SET ativo = 0 WHERE receita_id = ? AND ingrediente_id = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, receita_id);
        pstmt.setInt(2, ingrediente_id);

        boolean flag = pstmt.executeUpdate() == 1;

        pstmt.close();
        conn.close();

        return flag;
    }

    @Override
    public ArrayList<Ingrediente> retornarIngredientesReceita(int receita_id) throws SQLException {
        Connection conn = FabricaDeConexoes.getConnection();
        ArrayList<Ingrediente> ingredientes = new ArrayList<>();

        String sql = "SELECT * FROM receita_ingrediente R, ingrediente I WHERE R.ingrediente_id = I.id AND receita_id = ? AND ativo = 1";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, receita_id);

        ResultSet rs = pstmt.executeQuery();

        while(rs.next()) {
            int id = rs.getInt( "id");
            String nome = rs.getString("nome");
            String medida = rs.getString("medida");
            int quantidade = rs.getInt("quantidade");

            Ingrediente i = new Ingrediente(id, nome, medida, quantidade);
            ingredientes.add(i);
        }

        rs.close();
        pstmt.close();
        conn.close();

        return ingredientes;
    }

    @Override
    public boolean cadastrarIngredienteReceita(int receita_id, int ingrediente_id, String medida, int quantidade) throws SQLException {
        Connection conn = FabricaDeConexoes.getConnection();

        String sql = "INSERT INTO receita_ingrediente(receita_id, ingrediente_id, medida, quantidade) VALUES (?, ?, ?, ?)";
        
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, receita_id);
        pstmt.setInt(2, ingrediente_id);
        pstmt.setString(3, medida);
        pstmt.setInt(4, quantidade);

        int flag = pstmt.executeUpdate();

        conn.close();
        pstmt.close();

        return flag == 1;
    }
    
}
