package br.ifpr.edu.receitas.screens;

import java.io.IOException;

import br.ifpr.edu.receitas.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginUsuario {
    
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfSenha;

    @FXML
    private Button btLogar;
    @FXML
    private Button btLimpar;

    @FXML
    private Label labelTelaCadastro;

    public void initialize(){
        labelTelaCadastro.setOnMouseClicked(event ->{
            try {
                App.setRoot("cadastro-usuario");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @FXML
    private void logar(){
    }

    @FXML
    private void limpar(){
        tfEmail.clear();
        tfSenha.clear();
    }
}
