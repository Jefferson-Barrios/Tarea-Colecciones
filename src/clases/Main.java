package clases;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GestorProductos gestor = new GestorProductos();

        gestor.cargarDesdeArchivo();

        try (Scanner scanner = new Scanner(System.in)) {
            int opcion = 0;

            do {
                System.out.println("\n SISTEMA DE GESTION DE PRODUCTOS :");
                System.out.println("1. Crear nuevo producto");
                System.out.println("2. Mostrar todos los productos");
                System.out.println("3. Actualizar precio de producto");
                System.out.println("4. Eliminar producto");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opcion: ");

                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    System.out.println("Por favor, ingrese un numero valido");
                    scanner.nextLine();
                    continue;
                }

                switch (opcion) {
                    case 1:
                        System.out.println("\n CREAR NUEVO PRODUCTO :");
                        System.out.print("Ingrese ID del producto: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        if (gestor.buscarProductoPorId(id) != null) {
                            System.out.println("Error: Ya existe un producto con ese ID.");
                            break;
                        }

                        System.out.print("Ingrese nombre del producto: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Ingrese precio del producto: ");
                        double precio = scanner.nextDouble();
                        scanner.nextLine();

                        Producto nuevoProducto = new Producto(id, nombre, precio);
                        gestor.agregarProducto(nuevoProducto);
                        System.out.println("Producto agregado correctamente.");
                        gestor.guardarEnArchivo();
                        break;

                    case 2:
                        gestor.mostrarProductos();
                        break;

                    case 3:
                        System.out.println("\n ACTUALIZAR PRECIO DE PRODUCTO :");
                        System.out.print("Ingrese ID del producto a actualizar: ");
                        int idActualizar = scanner.nextInt();
                        scanner.nextLine();

                        if (gestor.buscarProductoPorId(idActualizar) == null) {
                            System.out.println("Error: No existe un producto con ese ID.");
                            break;
                        }

                        System.out.print("Ingrese el nuevo precio: ");
                        double nuevoPrecio = scanner.nextDouble();
                        scanner.nextLine();

                        boolean actualizado = gestor.actualizarProducto(idActualizar, nuevoPrecio);
                        if (actualizado) {
                            System.out.println("Precio actualizado correctamente.");
                            gestor.guardarEnArchivo();
                        }
                        break;

                    case 4:
                        System.out.println("\n ELIMINAR PRODUCTO :");
                        System.out.print("Ingrese ID del producto a eliminar: ");
                        int idEliminar = scanner.nextInt();
                        scanner.nextLine();

                        boolean eliminado = gestor.eliminarProducto(idEliminar);
                        if (eliminado) {
                            System.out.println("Producto eliminado correctamente.");
                            gestor.guardarEnArchivo();
                        } else {
                            System.out.println("Error: No existe un producto con ese ID.");
                        }
                        break;

                    case 5:
                        gestor.guardarEnArchivo();
                        System.out.println("Saliendo del sistema");
                        break;

                    default:
                        System.out.println("Opcion no valida. Intente nuevamente.");
                }
            } while (opcion != 5);
        }
    }
}