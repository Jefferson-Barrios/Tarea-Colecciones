package clases;

import java.util.ArrayList;

public class GestorProductos {
    private ArrayList<Producto> productos;

    public GestorProductos() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados en el sistema");
        } else {
            System.out.println("\n LISTA DE PRODUCTOS:");
            for (Producto p : productos) {
                System.out.println(p.toString());
            }
        }
    }

    public boolean actualizarProducto(int id, double nuevoPrecio) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                p.setPrecio(nuevoPrecio);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarProducto(int id) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId() == id) {
                productos.remove(i);
                return true;
            }
        }
        return false;
    }

    public Producto buscarProductoPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
