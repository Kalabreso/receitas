package br.ifpr.edu.receitas.screens;

import java.io.IOException;

import br.ifpr.edu.receitas.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CadastroUsuario {

    @FXML
    private TextField tfNome;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfSenha;

    @FXML
    private Button btCadastrar;
    @FXML
    private Button btLimpar;

    @FXML
    private Label labelTelaLogin;

    public void initialize(){
        labelTelaLogin.setOnMouseClicked(event -> {
            try {
                App.setRoot("login-usuario");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    
    @FXML
    private void cadastrar(){
    }

    @FXML
    private void limpar(){
        tfNome.clear();
        tfEmail.clear();
        tfSenha.clear();
    }
}
