import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseLoader {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/Losglobitos1";
    private static final String USERNAME = "tu_usuario";
    private static final String PASSWORD = "tu_contraseña";

    public static void main(String[] args) {
        loadClientes();
    }

    public static void loadClientes() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            cliente[] clientes = objectMapper.readValue(new File("clientes.json"), Cliente[].class);

            for (cliente cliente : clientes) {
                String sql = "INSERT INTO Clientes (ClienteID, Nombre, Dirección, Teléfono, Email) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, cliente.ClienteID);
                    statement.setString(2, cliente.Nombre);
                    statement.setString(3, cliente.Dirección);
                    statement.setString(4, cliente.Teléfono);
                    statement.setString(5, cliente.Email);
                    statement.executeUpdate();
                }
            }

            System.out.println("Datos de clientes insertados con éxito.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
