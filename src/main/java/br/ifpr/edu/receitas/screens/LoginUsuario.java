package br.ifpr.edu.receitas.screens;

import java.io.IOException;

import br.ifpr.edu.receitas.App;
import br.ifpr.edu.receitas.models.Usuario;
import br.ifpr.edu.receitas.repositories.RepositorioUsuario;
import br.ifpr.edu.receitas.utils.VariavelGlobalUsuario;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

    RepositorioUsuario repositorioUsuario = new RepositorioUsuario();

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
        String email = tfEmail.getText();
        String senha = tfSenha.getText();

        boolean deuCerto = true;
        String msg = "";

        if(email.isEmpty() || email.isBlank()) {
            deuCerto = false;
            msg += "\nEmail não pode estar vazio!!";
        }
        if(senha.isEmpty() || senha.isBlank()) {
            deuCerto = false;
            msg += "\nSenha não pode estar vazio!!";
        }

        if(deuCerto) {
            Usuario usuario = repositorioUsuario.logarUsuario(email, senha);
            
            if(usuario != null) {
                msg = "Login realizado com sucesso!";
                VariavelGlobalUsuario.setUsuario(usuario);
            } else {
                msg = "Erro no login! Usuário não encontrado";
                deuCerto = false;
            }
        }

        Alert alert = new Alert(deuCerto ? AlertType.INFORMATION : AlertType.ERROR, msg);
        alert.showAndWait();

        if(deuCerto) {
            try {
                App.setRoot("home");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void limpar(){
        tfEmail.clear();
        tfSenha.clear();
    }
}
