package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GestorProductos {
    private ArrayList<Producto> productos;
    private static final String NOMBRE_ARCHIVO = "productos.txt";

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

    public void guardarEnArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO))) {
            for (Producto p : productos) {
                String linea = p.getId() + "," + p.getNombre() + "," + p.getPrecio();
                bw.write(linea);
                bw.newLine();
            }
            System.out.println("Datos guardados correctamente en " + NOMBRE_ARCHIVO);
        } catch (IOException e) {
            System.out.println("Error al guardar en el archivo: " + e.getMessage());
        }
    }

    public void cargarDesdeArchivo() {
        productos.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    int id = Integer.parseInt(partes[0]);
                    String nombre = partes[1];
                    double precio = Double.parseDouble(partes[2]);
                    productos.add(new Producto(id, nombre, precio));
                }
            }
            System.out.println("Datos cargados correctamente desde " + NOMBRE_ARCHIVO);
        } catch (IOException e) {
            System.out.println("No se encontro el archivo " + NOMBRE_ARCHIVO + ". Se creara al guardar.");
        } catch (NumberFormatException e) {
            System.out.println("Error al leer datos del archivo: " + e.getMessage());
        }
    }
}
