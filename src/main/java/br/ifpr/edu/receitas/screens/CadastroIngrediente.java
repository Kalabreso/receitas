package br.ifpr.edu.receitas.screens;

import br.ifpr.edu.receitas.repositories.RepositorioIngrediente;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class CadastroIngrediente {
    
    @FXML
    private TextField tfIngrediente;

    RepositorioIngrediente repositorioIngrediente = new RepositorioIngrediente();

    @FXML
    private void cadastrar(){
        String nomeIngrediente = tfIngrediente.getText();

        boolean deuCerto = true;
        String msg = "";

        if(nomeIngrediente.isEmpty() || nomeIngrediente.isBlank()){
            deuCerto = false;
            msg += "\nIngrediente não pode estar vazio!!";
        }
        
        if(deuCerto){
            if(repositorioIngrediente.cadastrarIngrediente(nomeIngrediente)){
                msg = "Ingrediente cadastrada com sucesso!";
                limpar();
            } else {
                msg = "Erro ao cadastrar ingrediente!";
                deuCerto = false;
            }
        }

        Alert alert = new Alert(deuCerto ? AlertType.INFORMATION : AlertType.ERROR, msg);
        alert.showAndWait();
    }

    @FXML void limpar(){
        tfIngrediente.clear();
    }
}
