package br.ifpr.edu.receitas.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ifpr.edu.receitas.daos.interfaces.ReceitaDAO;
import br.ifpr.edu.receitas.models.Receita;
import br.ifpr.edu.receitas.utils.FabricaDeConexoes;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }

    @Override
    public boolean atualizar(Receita receita) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public boolean remover(Receita receita) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }
    
}
