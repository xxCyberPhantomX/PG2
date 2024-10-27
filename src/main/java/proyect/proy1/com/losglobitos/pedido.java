package proyect.proy1.com.losglobitos;

import java.util.List;

public class pedido {
    private int id;
    private cliente cliente;
    private List<producto> productos;
    private String estado;

    // Constructor
    public pedido(int id, cliente cliente, List<producto> productos) {
        this.id = id;
        this.cliente = cliente;
        this.productos = productos;
        this.estado = "En proceso";
    }

    pedido(cliente cliente, List<producto> productos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public cliente getCliente() {
        return cliente;
    }

    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }

    public List<producto> getProductos() {
        return productos;
    }

    public void setProductos(List<producto> productos) {
        this.productos = productos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Método para actualizar estado del pedido
    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    // Sobrescribir toString() para representar el pedido como texto
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido ID: ").append(id)
          .append(", Cliente: ").append(cliente.getNombre())  // Asumiendo que Cliente tiene un método getNombre()
          .append(", Estado: ").append(estado)
          .append(", Productos: ");
        
        for (producto producto : productos) {
            sb.append(producto.getNombre()).append(", "); // Asumiendo que Producto tiene un método getNombre()
        }

        // Eliminar la última coma y espacio
        if (sb.length() > 2) {
            sb.setLength(sb.length() - 2);
        }

        return sb.toString();
    }
}
