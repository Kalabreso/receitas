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

public class EditarRemoverIngrediente {

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

        cbReceitas.setOnAction(event -> {
            cbIngredientes.getItems().clear();
            Receita receita = cbReceitas.getValue();
            if(receita != null){
                cbIngredientes.setDisable(false);
                cbIngredientes.getItems().addAll(receita.getIngredientes());
            }
        });

        cbIngredientes.setOnAction(event -> {
            Ingrediente ingrediente = cbIngredientes.getValue();
            
            if(ingrediente != null){
                tfMedida.setDisable(false);
                tfQuantidade.setDisable(false);

                tfMedida.setText(ingrediente.getMedida());
                tfQuantidade.setText(ingrediente.getQuantidade().toString());
            }
        });
    }
    
    @FXML
    private void editar(){
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
            if(repositorioIngrediente.atualizarIngrediente(receita.getId(), ingrediente.getId(), ingrediente.getNome(), medida, quantidade)){
                msg = "Ingrediente atualizado com sucesso na receita!";
                limpar();
            } else {
                msg = "Erro ao atualizar!";
                deuCerto = false;
            }
        }

        Alert alert = new Alert(deuCerto ? AlertType.INFORMATION : AlertType.ERROR, msg);
        alert.showAndWait();
    }

    @FXML
    private void remover(){
        Receita receita = cbReceitas.getValue();
        Ingrediente ingrediente = cbIngredientes.getValue();

        boolean deuCerto = true;
        String msg = "";

        if(receita == null){
            deuCerto = false;
            msg += "Uma receita deve ser selecionada!!";
        }
        if(ingrediente == null){
            deuCerto = false;
            msg += "Um ingrediente deve ser selecionado!!";
        }

        if(deuCerto){
            if(repositorioIngrediente.removerIngrediente(receita.getId(), ingrediente.getId())){
                msg = "Ingrediente da receita removida com sucesso!";
                limpar();
            } else {
                msg = "Erro ao remover!";
                deuCerto = false;
            }
        }

        Alert alert = new Alert(deuCerto ? AlertType.INFORMATION : AlertType.ERROR, msg);
        alert.showAndWait();
    }
    
    private void limpar(){
        cbReceitas.getSelectionModel().clearSelection();
        cbIngredientes.getSelectionModel().clearSelection();
        cbReceitas.getItems().clear();
        cbIngredientes.getItems().clear();
        tfMedida.clear();
        tfQuantidade.clear();

        cbIngredientes.setDisable(true);
        tfMedida.setDisable(true);
        tfQuantidade.setDisable(true);

        cbReceitas.getItems().addAll(repositorioReceita.listarReceitasUsuario());
    }
}
