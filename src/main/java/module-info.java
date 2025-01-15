module br.ifpr.edu.receitas {
    requires javafx.controls;
    requires javafx.fxml;
    
    requires io.github.cdimascio.dotenv.java;
    requires java.sql;

    opens br.ifpr.edu.receitas.screens to javafx.fxml;
    exports br.ifpr.edu.receitas;
}
