package Tienda;

import Productos.Accesorios;
import Productos.Game;
import Productos.Herramientas;
import Productos.Home;
import Productos.Producto;
import Productos.Ropa;
import java.util.ArrayList;
import java.util.List;

public class MenuCliente {

    public static void menuCliente(ListLister listLister) {

        Producto[] random = new Producto[5];
        int[] randomIndices = Atajos.fiveRandom(listLister.getProductos().size());
        Atajos.imprimir("Productos destacados:");
        for (int i = 0; i < 5; i++) {
            random[i] = listLister.getProductos().get(randomIndices[i]);
            Atajos.imprimir(random[i].showData(i + 1));
        }
        boolean condition = true;

        Atajos.imprimirSeparador();
        Atajos.imprimir("Bienvenido al menú de cliente");
        do {
            Atajos.imprimirSeparador();
            Atajos.mostrarMenu(new String[]{"Productos destacados", "Buscar Productos", "Ver carrito", "Realizar compra"});

            int opcion = Atajos.getNum();

            switch (opcion) {
                case 1 -> {
                    Atajos.imprimir("Productos destacados:");
                    for (int i = 0; i < random.length; i++) {
                        Atajos.imprimir(random[i].showData(i + 1));

                    }
                    Atajos.imprimirSeparador();
                    Atajos.imprimir("Seleccione un producto del menú mostrando un número:");

                    int num = Atajos.getNum();
                    if (num < 1 || num > random.length + 1) {
                        Atajos.imprimir("Número inválido. Has vuelto al menú.");

                        break;
                    } else {
                        Atajos.imprimir(random[num - 1].showData(opcion));

                        agragarAlCarrito(listLister, List.of(random), num, true);
                    }
                    
                }
                case 2 -> {
                    Atajos.imprimirSeparador();
                    Atajos.imprimir("Ingrese el nombre del producto que desea buscar:");
                    String nombreBusqueda = Atajos.getTexto();
                    List<Producto> productoBuscado = new ArrayList<>();
                    for (Producto producto : listLister.getProductos()) {
                        if (producto.getName().toLowerCase().contains(nombreBusqueda.toLowerCase())) {
                            productoBuscado.add(producto);
                        }
                    }
                    if (productoBuscado.isEmpty()) {
                        Atajos.imprimir("No se encontraron productos con ese nombre.");
                    } else {
                        Atajos.imprimir("Productos encontrados:");
                        for (int i = 0; i < productoBuscado.size(); i++) {
                            Atajos.imprimir(productoBuscado.get(i).showData(i + 1));
                        }
                        Atajos.imprimirSeparador();
                        Atajos.imprimir("Seleccione un producto del menú mostrando un número:");
                        int num = Atajos.getNum();
                        if (num < 1 || num > productoBuscado.size()) {
                            Atajos.imprimir("Número inválido. Por favor, seleccione un número válido.");
                        } else {
                            boolean comprado = true;
                            if (productoBuscado.get(num - 1).getStock() <= 0) {
                                Atajos.imprimir("Lo sentimos, el producto está agotado y no se puede agregar al carrito.");
                            } else {

                                agragarAlCarrito(listLister, productoBuscado, num, comprado);

                            }
                        }
                    }
                }
                case 3 -> {
                    
                    if (listLister.getCarrito().isEmpty()) {
                        Atajos.imprimir("El carrito está vacío.");
                    } else {
                        Atajos.imprimir("Productos en el carrito:");
                        for (Producto producto : listLister.getCarrito()) {
                            Atajos.imprimir(producto.showData(listLister.getCarrito().indexOf(producto) + 1));
                        }
                    }
                    Atajos.imprimirSeparador();
                }
                case 4 -> {
                    try {
                        if (listLister.getCarrito().isEmpty()){
                            Atajos.imprimir("El carrito está vacío. No se puede realizar la compra.");
                            break;
                        } else {
                            double total = 0.0;
                            for(Producto p : listLister.getCarrito()){
                                Atajos.imprimir(p.showData(listLister.getCarrito().indexOf(p) + 1));
                                total += p.getPrice();
                            }
                            Atajos.imprimir("Total a pagar: " + total);
                            Atajos.imprimir("¿Desea confirmar la compra? (s/n)");
                            String respuesta = Atajos.getTexto();
                            if (respuesta.equalsIgnoreCase("s")){
                                Atajos.imprimir("Añada la cantidad de dinero necesaria para completar la compra:");
                                try {
                                    double dinero = Atajos.getNum();
                                    if (dinero >= total) {
                                        double cambio = dinero - total;
                                        Atajos.imprimir("Compra realizada con éxito.");
                                        Atajos.imprimir("Su cambio es: " + cambio + " € \n Muchas gracias por su compra.");
                                        listLister.getCarrito().clear();
                                    } else {
                                        Atajos.imprimir("Dinero insuficiente. No se puede realizar la compra.");
                                        Atajos.imprimir("le faltan: " + (total - dinero) + " €");
                                        Atajos.imprimirSeparador();
                                        Atajos.imprimir("Compra cancelada.");
                                        break;  
                                    }
                                } catch (Exception e) {
                                    Atajos.imprimir("Error al ingresar la cantidad de dinero. Compra cancelada.");
                                }
                            } else if (respuesta.equalsIgnoreCase("n")) {
                                Atajos.imprimir("Compra cancelada.");
                            }else{
                                Atajos.imprimir("Resppuesta no valida , intentalo de nuevo");
                            }
                        }
                    } catch (Exception e) {
                        Atajos.imprimir("Ha ocurrido un error durante el proceso de compra. Inténtelo de nuevo.");
                    }
                }
                    case 5 ->{
                    Atajos.imprimir("Hasta la próxima.");
                    condition = false;
                }
                default ->
                    Atajos.imprimir("Opción no válida.");
            }

        } while (condition);
    }
    public static void agragarAlCarrito(ListLister listLister, List<Producto> productoBuscado, int num, boolean comprado) {

        Atajos.imprimir("¿Desea agregar este producto al carrito? (s/n)");
        String respuesta = Atajos.getTexto();
        if (respuesta.equalsIgnoreCase("s")) {
            Producto productoTienda = productoBuscado.get(num - 1);

            if (productoTienda.getStock() <= 0) {

                Atajos.imprimir("Lo sentimos, el producto está agotado y no se puede agregar al carrito.");
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
                Atajos.imprimir("Producto agregado al carrito.");
            } else {

                Producto nuevoProducto; // Establece el stock inicial en 1 para el nuevo producto en el carrito

                switch (productoTienda.typeProducto()) {
                    case "Ropa":
                        nuevoProducto = new Ropa(productoTienda.getName(), productoTienda.getPrice(), 1);
                        break;
                    case "Electronica":
                        nuevoProducto = new Accesorios(productoTienda.getName(), productoTienda.getPrice(), 1);
                        break;
                    case "Home":
                        nuevoProducto = new Home(productoTienda.getName(), productoTienda.getPrice(), 1);
                        break;
                    case "Juego":
                        nuevoProducto = new Game(productoTienda.getName(), productoTienda.getPrice(), 1);
                        break;
                    case "Herramientas":
                        nuevoProducto = new Herramientas(productoTienda.getName(), productoTienda.getPrice(), 1);
                        break;
                    default:
                        nuevoProducto = new Ropa(productoTienda.getName(), productoTienda.getPrice(), 1); // Fallback
                        break;
                }

                listLister.getCarrito().add(nuevoProducto);
                productoTienda.setStock(productoTienda.getStock() - 1);
                Atajos.imprimir("Producto agregado al carrito.");
            }
        } else if (respuesta.equalsIgnoreCase("n")) {
            Atajos.imprimir("Producto no agregado al carrito.");
        } else {
            Atajos.imprimir("Respuesta no válida. Producto no agregado al carrito.");
        }
    }
    
}
