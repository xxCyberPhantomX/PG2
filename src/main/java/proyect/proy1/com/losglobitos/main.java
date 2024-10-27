package proyect.proy1.com.losglobitos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Los Globitos");

        Button btnOrdenCompra = new Button("Orden de Compra");
        btnOrdenCompra.setOnAction(e -> new OrdenCompra().mostrar());

        Button btnOrdenVenta = new Button("Orden de Venta");
        btnOrdenVenta.setOnAction(e -> new OrdenVenta().mostrar());

        Button btnProduccion = new Button("Producción");
        btnProduccion.setOnAction(e -> new Produccion().mostrar());

        Button btnImportacion = new Button("Importación");
        btnImportacion.setOnAction(e -> new Importacion().mostrar());

        Button btnFacturacion = new Button("Facturación");
        btnFacturacion.setOnAction(e -> new Facturacion().mostrar());

        Button btnAlmacenamiento = new Button("Almacenamiento");
        btnAlmacenamiento.setOnAction(e -> new Almacenamiento().mostrar());

        VBox vBox = new VBox(btnOrdenCompra, btnOrdenVenta, btnProduccion, btnImportacion, btnFacturacion, btnAlmacenamiento);
        Scene scene = new Scene(vBox, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

        // Aquí sigue la lógica existente
        controlador controlador = new controlador();
        inventario inventario = new inventario.getInstancia();
        ProductoFactory factory = new ProductoFactoryImpl();
        AlmacenamientoProducto storage = new AlmacenamientoProducto();

        // Crear algunos productos para un pedido
        producto sombrilla = new producto(1, "Sombrilla", "local", 50.0);
        producto taza = new producto(2, "Taza", "importado", 30.0);
        List<producto> productos = Arrays.asList(sombrilla, taza);

        // Crear un pedido
        pedido pedido1 = new pedido(101, new cliente("Juan Pérez", "contacto@example.com"), productos);
        List<pedido> pedidos = Arrays.asList(pedido1);

        // Guardar pedidos en un archivo
        try {
            controlador.guardarPedidos(pedidos, "pedidos.txt");
            System.out.println("Pedidos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error