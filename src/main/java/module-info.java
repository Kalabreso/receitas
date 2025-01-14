module br.ifpr.edu.receitas {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.ifpr.edu.receitas to javafx.fxml;
    exports br.ifpr.edu.receitas;
}
