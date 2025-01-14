package br.ifpr.edu.receitas.screens;

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

    @FXML
    public void initialize(){
        labelTelaCadastro.setOnMouseClicked(event ->{
            System.out.println("Texto clicado!!!");
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
