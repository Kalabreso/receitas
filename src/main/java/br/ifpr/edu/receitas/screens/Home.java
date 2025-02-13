package br.ifpr.edu.receitas.screens;

import java.io.IOException;
import java.util.Optional;

import br.ifpr.edu.receitas.App;
import br.ifpr.edu.receitas.repositories.RepositorioUsuario;
import br.ifpr.edu.receitas.utils.VariavelGlobalUsuario;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
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
    private void cadastrarIngrediente() throws IOException{
        painelCentral.getChildren().clear();
        painelCentral.getChildren().add(App.loadFXML("cadastro-ingrediente"));
    }

    @FXML
    private void cadastrarIngredienteReceita() throws IOException{
        painelCentral.getChildren().clear();
        painelCentral.getChildren().add(App.loadFXML("cadastro-ingrediente-receita"));
    }

    @FXML
    private void editarRemoverIngrediente() throws IOException{
        painelCentral.getChildren().clear();
        painelCentral.getChildren().add(App.loadFXML("editar-remover-ingrediente"));
    }

    @FXML
    private void removerUsuario() throws IOException{
        Alert alertConfirmar = new Alert(AlertType.CONFIRMATION, "Deseja mesmo remover esse usuário do banco de dados?");
        alertConfirmar.getButtonTypes().clear();
        alertConfirmar.getButtonTypes().add(ButtonType.YES);
        alertConfirmar.getButtonTypes().add(ButtonType.NO);

        RepositorioUsuario repositorioUsuario = new RepositorioUsuario();

        Optional<ButtonType> resultado = alertConfirmar.showAndWait();

        if(resultado.get() == ButtonType.YES){
            repositorioUsuario.removerUsuario(VariavelGlobalUsuario.getUsuario());
            VariavelGlobalUsuario.setUsuario(null);
            App.setRoot("login-usuario");
        }
    }
}
