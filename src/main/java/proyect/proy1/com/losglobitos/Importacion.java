package proyect.proy1.com.losglobitos;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Importacion {
    public void mostrar() {
        Stage stage = new Stage();
        stage.setTitle("Importación");

        Label label = new Label("Aquí puedes gestionar la importación");
        VBox vBox = new VBox(label);
        Scene scene = new Scene(vBox, 400, 300);

        stage.setScene(scene);
        stage.show();
    }
}
