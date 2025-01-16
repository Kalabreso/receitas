package br.ifpr.edu.receitas.screens;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

public class Home {
    
    @FXML
    private StackPane painelCentral;

    @FXML
    private void cadastrarReceita(){
        System.out.println("Cadastrar Receitas clicado!!");
    }

    @FXML
    private void editarReceita(){
        System.out.println("Editar Receitas clicado!!");
    }

    @FXML
    private void listarReceitas(){
        System.out.println("Listar Receitas clicado!!");
    }
}
