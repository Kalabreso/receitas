package br.ifpr.edu.receitas.screens;

import br.ifpr.edu.receitas.models.Receita;
import br.ifpr.edu.receitas.models.Usuario;
import br.ifpr.edu.receitas.repositories.RepositorioReceita;
import br.ifpr.edu.receitas.utils.VariavelGlobalUsuario;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class EditarRemoverReceita {

    @FXML
    private TextField tfNome;
    @FXML
    private TextField tfDescricao;
    @FXML
    private TextField tfIngredientes;

    @FXML
    private ComboBox<Receita> cbReceitas;

    RepositorioReceita repositorioReceita = new RepositorioReceita();

    public void initialize(){
        cbReceitas.getItems().addAll(repositorioReceita.listarReceitasUsuario());

        cbReceitas.setOnAction(event -> {
            Receita receita = cbReceitas.getValue();
            if(receita != null){
                tfNome.setText(receita.getNome());
                tfDescricao.setText(receita.getDescricao());
                tfIngredientes.setText(receita.getIngredientes());

                tfNome.setDisable(false);
                tfDescricao.setDisable(false);
                tfIngredientes.setDisable(false);
            }
        });
    }
    
    @FXML
    private void editar(){
        String nome = tfNome.getText();
        String ingredientes = tfIngredientes.getText();
        String descricao = tfDescricao.getText();
        Usuario usuario = VariavelGlobalUsuario.getUsuario();

        boolean deuCerto = true;
        String msg = "";

        if(nome.isEmpty() || nome.isBlank()){
            deuCerto = false;
            msg += "Nome não pode estar vazio!!";
        }
        if(ingredientes.isEmpty() || ingredientes.isBlank()){
            deuCerto = false;
            msg += "\nIngredientes não pode estar vazio!!";
        }
        if(descricao.isEmpty() || descricao.isBlank()){
            deuCerto = false;
            msg += "\nDescrição não pode estar vazio!!";
        }
        
        if(deuCerto){
            Receita receita = new Receita(cbReceitas.getValue().getId(), nome, ingredientes, descricao, usuario);

            if(repositorioReceita.atualizarReceita(receita)){
                msg = "Receita atualizada com sucesso!";
                limpar();
            } else {
                msg = "Erro ao atualizar receita!";
                deuCerto = false;
            }
        }

        Alert alert = new Alert(deuCerto ? AlertType.INFORMATION : AlertType.ERROR, msg);
        alert.showAndWait();
    }

    @FXML
    private void remover(){
        Receita receita = cbReceitas.getValue();

        boolean deuCerto = true;
        String msg = "";

        if(receita == null){
            deuCerto = false;
            msg += "Uma receita deve ser selecionada!!";
        }

        if(deuCerto){
            if(repositorioReceita.removerReceita(receita)){
                msg = "Receita removida com sucesso!";
                limpar();
            } else {
                msg = "Erro ao remover receita!";
                deuCerto = false;
            }
        }

        Alert alert = new Alert(deuCerto ? AlertType.INFORMATION : AlertType.ERROR, msg);
        alert.showAndWait();
    }

    private void limpar(){
        tfNome.clear();
        tfDescricao.clear();
        tfIngredientes.clear();
        tfNome.setDisable(true);
        tfDescricao.setDisable(true);
        tfIngredientes.setDisable(true);
        cbReceitas.getSelectionModel().clearSelection();

        cbReceitas.getItems().clear();
        cbReceitas.getItems().addAll(repositorioReceita.listarReceitasUsuario());
    }
}
