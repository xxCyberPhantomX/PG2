package proyect.proy1.com.losglobitos;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Almacenamiento {
    public void mostrar() {
        Stage stage = new Stage();
        stage.setTitle("Almacenamiento");

        Label label = new Label("Aquí puedes gestionar el almacenamiento");
        VBox vBox = new VBox(label);
        Scene scene = new Scene(vBox, 400, 300);

        stage.setScene(scene);
        stage.show();
    }
}
