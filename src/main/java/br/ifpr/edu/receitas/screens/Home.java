package br.ifpr.edu.receitas.screens;

import java.io.IOException;

import br.ifpr.edu.receitas.App;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

public class Home {
    
    @FXML
    private StackPane painelCentral;

    @FXML
    private void cadastrarReceita() throws IOException{
        painelCentral.getChildren().clear();
        painelCentral.getChildren().add(App.loadFXML("cadastro-receita"));
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
