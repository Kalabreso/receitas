package br.ifpr.edu.receitas.screens;

import br.ifpr.edu.receitas.models.Usuario;
import br.ifpr.edu.receitas.utils.VariavelGlobalUsuario;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EditarUsuario {

    @FXML
    private TextField tfNome;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfSenha;

    public void initialize(){
        Usuario usuario = VariavelGlobalUsuario.getUsuario();
        
        tfNome.setText(usuario.getNome());
        tfEmail.setText(usuario.getEmail());
        tfSenha.setText(usuario.getSenha());
    }
    
    @FXML
    private void atualizar(){
    }

    @FXML
    private void limpar(){
    }
}
