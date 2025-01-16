package br.ifpr.edu.receitas.screens;

import java.io.IOException;

import br.ifpr.edu.receitas.App;
import br.ifpr.edu.receitas.repositories.RepositorioUsuario;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

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

    private RepositorioUsuario repositorioUsuario = new RepositorioUsuario();

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
        String nome = tfNome.getText();
        String email = tfEmail.getText();
        String senha = tfSenha.getText();

        boolean deuCerto = true;
        String msg = "";

        if(nome.isEmpty() || nome.isBlank()){
            deuCerto = false;
            msg += "Nome não pode estar vazio!!";
        }
        if(email.isEmpty() || email.isBlank()){
            deuCerto = false;
            msg += "\nEmail não pode estar vazio!!";
        }
        if(senha.isEmpty() || senha.isBlank()){
            deuCerto = false;
            msg += "\nSenha não pode estar vazio!!";
        }
        
        if(deuCerto){
            if(repositorioUsuario.cadastrarUsuario(nome, email, senha)){
                msg = "Usuário cadastrado com sucesso!";
                limpar();
            } else {
                msg = "Erro ao cadastrar usuário!";
                deuCerto = false;
            }
        }

        Alert alert = new Alert(deuCerto ? AlertType.INFORMATION : AlertType.ERROR, msg);
        alert.showAndWait();
    }

    @FXML
    private void limpar(){
        tfNome.clear();
        tfEmail.clear();
        tfSenha.clear();
    }
}
