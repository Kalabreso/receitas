package br.ifpr.edu.receitas.screens;

import br.ifpr.edu.receitas.models.Ingrediente;
import br.ifpr.edu.receitas.models.Receita;
import br.ifpr.edu.receitas.repositories.RepositorioIngrediente;
import br.ifpr.edu.receitas.repositories.RepositorioReceita;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CadastroIngredienteReceita {

    @FXML
    private TextField tfMedida;
    @FXML
    private TextField tfQuantidade;

    @FXML
    private ComboBox<Receita> cbReceitas;
    @FXML
    private ComboBox<Ingrediente> cbIngredientes;

    RepositorioReceita repositorioReceita = new RepositorioReceita();
    RepositorioIngrediente repositorioIngrediente = new RepositorioIngrediente();

    public void initialize(){
        cbReceitas.getItems().addAll(repositorioReceita.listarReceitasUsuario());
        cbIngredientes.getItems().addAll(repositorioIngrediente.listarIngredientes());
    }
    
    @FXML
    private void cadastrar(){
        Receita receita = cbReceitas.getValue();
        Ingrediente ingrediente = cbIngredientes.getValue();
        String medida = tfMedida.getText();
        String stringQuant = tfQuantidade.getText();

        boolean deuCerto = true;
        String msg = "";
        int quantidade;

        if(medida.isEmpty() || medida.isBlank()){
            deuCerto = false;
            msg += "Medida não pode estar vazio!!";
        }
        if(stringQuant.isEmpty() || stringQuant.isBlank()){
            deuCerto = false;
            msg += "\nQuantitade não pode estar vazio!!";
        }
        if(receita == null){
            deuCerto = false;
            msg += "\nUma receita deve ser selecionada!!";
        }
        if(ingrediente == null){
            deuCerto = false;
            msg += "\nUm ingrediente deve ser selecionada!!";
        }
        
        if(deuCerto){
            quantidade = Integer.parseInt(stringQuant);
            if(repositorioIngrediente.cadastrarIngredienteReceita(receita.getId(), ingrediente.getId(), medida, quantidade)){
                msg = "Ingrediente cadastrado com sucesso na receita!";
                limpar();
            } else {
                msg = "Erro ao cadastrar!";
                deuCerto = false;
            }
        }

        Alert alert = new Alert(deuCerto ? AlertType.INFORMATION : AlertType.ERROR, msg);
        alert.showAndWait();
    }

    @FXML
    private void limpar(){
        cbReceitas.getSelectionModel().clearSelection();
        cbIngredientes.getSelectionModel().clearSelection();
        tfMedida.clear();
        tfQuantidade.clear();
    }
}
