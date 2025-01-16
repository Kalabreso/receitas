package br.ifpr.edu.receitas.screens;

import javafx.fxml.FXML;
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
    
    @FXML
    private void cadastrar(){
        
    }

    @FXML
    private void limpar(){
        tfNome.clear();
        tfDescricao.clear();
    }
}
