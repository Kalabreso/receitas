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
    private void editarRemoverReceita() throws IOException{
        painelCentral.getChildren().clear();
        painelCentral.getChildren().add(App.loadFXML("editar-remover-receita"));
    }

    @FXML
    private void listarReceitas() throws IOException{
        painelCentral.getChildren().clear();
        painelCentral.getChildren().add(App.loadFXML("lista_receitas"));
    }

    @FXML
    private void editarUsuario() throws IOException{
        painelCentral.getChildren().clear();
        painelCentral.getChildren().add(App.loadFXML("editar-usuario"));
    }

    @FXML
    private void removerUsuario(){
    }
}
