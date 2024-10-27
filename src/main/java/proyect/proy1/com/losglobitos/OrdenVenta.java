package proyect.proy1.com.losglobitos;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OrdenVenta {
    public void mostrar() {
        Stage stage = new Stage();
        stage.setTitle("Orden de Venta");

        Label label = new Label("Aquí puedes gestionar las órdenes de venta");
        VBox vBox = new VBox(label);
        Scene scene = new Scene(vBox, 400, 300);

        stage.setScene(scene);
        stage.show();
    }
}
