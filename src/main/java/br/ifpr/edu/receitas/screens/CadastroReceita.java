package br.ifpr.edu.receitas.screens;

import br.ifpr.edu.receitas.models.Usuario;
import br.ifpr.edu.receitas.repositories.RepositorioReceita;
import br.ifpr.edu.receitas.utils.VariavelGlobalUsuario;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastroReceita {

    @FXML
    private TextField tfNome;
    @FXML
    private TextField tfDescricao;

    @FXML
    private Button btCadastrar;
    @FXML
    private Button btLimpar;

    RepositorioReceita repositorioReceita = new RepositorioReceita();
    
    @FXML
    private void cadastrar(){
        String nome = tfNome.getText();
        String descricao = tfDescricao.getText();
        Usuario usuario = VariavelGlobalUsuario.getUsuario();

        boolean deuCerto = true;
        String msg = "";

        if(nome.isEmpty() || nome.isBlank()){
            deuCerto = false;
            msg += "Nome não pode estar vazio!!";
        }
        if(descricao.isEmpty() || descricao.isBlank()){
            deuCerto = false;
            msg += "\nDescrição não pode estar vazio!!";
        }
        
        if(deuCerto){
            if(repositorioReceita.cadastrarReceita(nome, descricao, usuario)){
                msg = "Receita cadastrada com sucesso!";
                limpar();
            } else {
                msg = "Erro ao cadastrar receita!";
                deuCerto = false;
            }
        }

        Alert alert = new Alert(deuCerto ? AlertType.INFORMATION : AlertType.ERROR, msg);
        alert.showAndWait();
    }

    @FXML
    private void limpar(){
        tfNome.clear();
        tfDescricao.clear();
    }
}
