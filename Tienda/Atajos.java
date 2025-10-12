/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author osasusan
 */
package Tienda;

import Productos.Accesorios;
import Productos.Game;
import Productos.Herramientas;
import Productos.Home;
import Productos.Producto;
import Productos.Ropa;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Atajos {

    public static void imprimir(String texto) { // imprime un texto en consola
        System.out.println(texto);

    }

    public static void mostrarMenu(String[] opciones) {
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i]);
        }
        System.out.println((opciones.length + 1) + ". Salir");
    }

    public static String getTexto() {
        String textInput = "";
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                try {
                    textInput = scanner.nextLine();
                    if (textInput.isEmpty()) {
                        imprimir("El texto no puede estar vacío, intente de nuevo.");
                        textInput = "";
                    }
                } catch (Exception e) {
                    errorAtajo("texto");
                    // Clear input to repeat loop
                    textInput = "";
                }
            } while (textInput.isEmpty());
        }
        return textInput;
    }

    public static String getEmaill() {
        String textInput = "";
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                try {
                    textInput = scanner.nextLine();
                    if (!textInput.contains("@") || !textInput.contains(".")) {
                        imprimir("Email inválido, no cumple los requisitos.\nPor favor, intente de nuevo.");
                        textInput = ""; // Clear input to repeat loop
                    }
                } catch (Exception e) {
                    errorAtajo("Email");
                    // Clear input to repeat loop

                }
            } while (textInput.isEmpty());
        }
        return textInput;
    }

    public static void imprimirSeparador() { // imprime una linea separadora
        imprimir("--------------------");
    }

    public static int getNum() { // recojer un numero INT desde consola 
        int num = -1;
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                try {
                    num = scanner.nextInt();
                } catch (Exception e) {
                    errorAtajo("numero");
                }
            } while (num == -1);
        }
        return num;
    }

    public static double getDouble() { // recojer un numero DOUBLE desde consola
        double num = -0.00;
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                try {
                    num = scanner.nextDouble();
                } catch (Exception e) {
                    errorAtajo("Double");
                }
            } while (num == -1);
        }
        return num;
    }

    public static float getFloat() { // recojer un numero FLOAT desde consola
        float num = 0.0f;
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                try {
                    num = scanner.nextFloat();
                } catch (Exception e) {
                    errorAtajo("Float");
                }
            } while (num == 0.0f);
        }
        return num;
    }

    public static int[] fiveRandom(int size) {
        int[] list = new int[5];
        int number;
        Random random = new Random();

        for (int i = 0; i < list.length; i++) {
            do {
                number = random.nextInt(size);
            } while (!numberNotInArray(list, number));
            list[i] = number;
        }
        return list;
    }

    public static boolean numberNotInArray(int[] array, int number) {
        for (int value : array) {
            if (value == number) {
                return false;
            }
        }
        return true;
    }

    // Método para imprimir nombre y precio de 5 productos aleatorios
    public static void imprimir5ProductosAleatorios(List<Producto> productos) {
        if (productos == null || productos.size() < 5) {
            imprimir("La lista debe tener al menos 5 elementos.");
            return;
        }
        int[] indices = fiveRandom(productos.size());
        for (int idx : indices) {
            Producto producto = productos.get(idx);
            imprimir("Nombre: " + producto.getName() + ", Precio: " + producto.getPrice());
        }
    }

    public static void agragarAlCarrito(ListLister listLister, List<Producto> productoBuscado, int num, boolean comprado) {

        imprimir("¿Desea agregar este producto al carrito? (s/n)");
        String respuesta = getTexto();
        if (respuesta.equalsIgnoreCase("s")) {
            Producto productoTienda = productoBuscado.get(num - 1);

            if (productoTienda.getStock() <= 0) {

                imprimir("Lo sentimos, el producto está agotado y no se puede agregar al carrito.");
                return;
            }

            Producto poductoEnCarrito = null;
            for (Producto p : listLister.getCarrito()) {
                if (p.getName().equals(productoTienda.getName())) {
                    poductoEnCarrito = p;
                    break;
                }
            }
            // Si el producto ya está en el carrito, incrementa su stock
            if (poductoEnCarrito != null) {
                poductoEnCarrito.setStock(poductoEnCarrito.getStock() + 1);
                poductoEnCarrito.setPrice(poductoEnCarrito.getPrice() + poductoEnCarrito.getPrice());
                imprimir("Producto agregado al carrito.");
            } else {

                Producto nuevoProducto; // Establece el stock inicial en 1 para el nuevo producto en el carrito
                nuevoProducto = switch (productoTienda.typeProducto()) {
                    case "Ropa" -> new Ropa(productoTienda.getName(), productoTienda.getPrice(), 1);
                    case "Electronica" -> new Accesorios(productoTienda.getName(), productoTienda.getPrice(), 1);
                    case "Home" -> new Home(productoTienda.getName(), productoTienda.getPrice(), 1);
                    case "Juego" -> new Game(productoTienda.getName(), productoTienda.getPrice(), 1);
                    case "Herramientas" -> new Herramientas(productoTienda.getName(), productoTienda.getPrice(), 1);
                    default -> new Ropa(productoTienda.getName(), productoTienda.getPrice(), 1);
                }; // Fallback

                listLister.getCarrito().add(nuevoProducto);

                imprimir("Producto agregado al carrito.");
            }
            productoTienda.setStock(productoTienda.getStock() - 1);
        } else if (respuesta.equalsIgnoreCase("n")) {
            imprimir("Producto no agregado al carrito.");
        } else {
            imprimir("Respuesta no válida. Producto no agregado al carrito.");
        }
    }

    public static void buscarOBorrar(ListLister listLister, boolean delete) {
        imprimirSeparador();
        imprimir("Ingrese el nombre del producto que desea buscar:");
        String nombreBusqueda = getTexto();
        List<Producto> productoBuscado = new ArrayList<>();
        for (Producto producto : listLister.getProductos()) {
            if (producto.getName().toLowerCase().contains(nombreBusqueda.toLowerCase())) {
                productoBuscado.add(producto);
            }
        }
        if (productoBuscado.isEmpty()) {
            imprimir("No se encontraron productos con ese nombre.");
        } else {
            imprimir("Productos encontrados:");
            for (int i = 0; i < productoBuscado.size(); i++) {
                imprimir(productoBuscado.get(i).showData(i + 1));
            }
            imprimirSeparador();
            imprimir("Seleccione un producto del menú mostrando un número:");
            int num = getNum();
            if (num < 1 || num > productoBuscado.size()) {
                imprimir("Número inválido. Por favor, seleccione un número válido.");
            } else {
                if (!delete) {
                    boolean comprado = true;
                    if (productoBuscado.get(num - 1).getStock() <= 0) {
                        imprimir("Lo sentimos, el producto está agotado y no se puede agregar al carrito.");
                    } else {

                        agragarAlCarrito(listLister, productoBuscado, num, comprado);

                    }
                } else {
                    listLister.getProductos().remove(productoBuscado.get(num - 1));
                    imprimir("Producto has borrado " + productoBuscado.get(num - 1).getName() + " exitosamente");
                }
            }
        }
    }

    private static void errorAtajo(String property) { // metodo para manejar errores
        imprimir(" Error a la hora de obtener un " + property + " ,\nPor favor, intentalo de nuevo.");
    }
}
