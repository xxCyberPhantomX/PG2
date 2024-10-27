package  proyect.proy1.com.losglobitos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.losglobitos.model.producto;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AlmacenamientoProducto {
    private static final String FILE_PATH = "productos.json";
    private Gson gson;

    public AlmacenamientoProducto() {
        gson = new Gson();
    }

    public void guardarProductos(List<producto> productos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            String json = gson.toJson(productos);
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<producto> cargarProductos() {
        List<producto> productos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            Type listType = new TypeToken<List<producto>>(){}.getType();
            productos = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productos;
    }
}
