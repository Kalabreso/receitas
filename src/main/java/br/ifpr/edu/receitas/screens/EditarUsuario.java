package br.ifpr.edu.receitas.screens;

import br.ifpr.edu.receitas.models.Usuario;
import br.ifpr.edu.receitas.repositories.RepositorioUsuario;
import br.ifpr.edu.receitas.utils.VariavelGlobalUsuario;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class EditarUsuario {

    @FXML
    private TextField tfNome;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfSenha;

    RepositorioUsuario repositorioUsuario = new RepositorioUsuario();

    public void initialize(){
        Usuario usuario = VariavelGlobalUsuario.getUsuario();
        
        tfNome.setText(usuario.getNome());
        tfEmail.setText(usuario.getEmail());
        tfSenha.setText(usuario.getSenha());
    }
    
    @FXML
    private void atualizar(){
        int id = VariavelGlobalUsuario.getUsuario().getId();
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
            Usuario usuario = new Usuario(id, nome, email, senha);

            if(repositorioUsuario.atualizarUsuario(usuario)){
                msg = "Usuário atualizado com sucesso!";
                VariavelGlobalUsuario.setUsuario(usuario);
                limpar();
            } else {
                msg = "Erro ao atualizar usuário!";
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
