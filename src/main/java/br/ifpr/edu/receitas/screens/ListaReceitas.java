package br.ifpr.edu.receitas.screens;

import java.util.ArrayList;

import br.ifpr.edu.receitas.models.Ingrediente;
import br.ifpr.edu.receitas.models.Receita;
import br.ifpr.edu.receitas.repositories.RepositorioReceita;
import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class ListaReceitas {
    
    @FXML
    private FlowPane rootPane;

    RepositorioReceita repositorioReceita = new RepositorioReceita();

    public void initialize(){
        ArrayList<Receita> receitas = new ArrayList<>();
        receitas = repositorioReceita.listarReceitas();

        for(Receita receita : receitas){
            Text text = new Text(stringLista(receita));
            TextFlow textFlow = new TextFlow(text);

            textFlow.setStyle(
                "-fx-background-color: white; " +
                "-fx-border-color: lightgray; " +
                "-fx-border-width: 1; " +
                "-fx-padding: 5;" +
                "-fx-pref-width: 220px;" +
                "-fx-pref-height: 450px;"
            );
            rootPane.getChildren().add(textFlow);
        }
    }

    String stringLista(Receita receita){
        return "USUARIO(DONO) DA RECEITA:\n" +
            receita.getUsuario().getNome() +
            "\n" +
            receita.getUsuario().getEmail() +
            "\n\n" +
            "NOME DA RECEITA:\n" +
            receita.getNome() +
            "\n\n" +
            "INGREDIENTES:\n" +
            stringIngredientes(receita.getIngredientes()) +
            "\n" +
            "DESCRIÇÃO:\n" +
            receita.getDescricao()
        ;
    }

    String stringIngredientes(ArrayList<Ingrediente> ingredientes){
        String msg = "";

        for(Ingrediente i : ingredientes){
            msg += i.getQuantidade() + " " + i.getMedida() + " de " + i.getNome() + "\n";
        }

        return msg;
    }
}
