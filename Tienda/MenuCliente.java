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

    public static void menuCliente(ListLister listLister, boolean isLog) {

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
            Atajos.imprimirSeparador();

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

                        Atajos.agragarAlCarrito(listLister, List.of(random), num, true);
                    }

                }
                case 2 -> {
                    Atajos.mostrarMenu(new String[]{"Categorias", "Buscador global"});
                    int getOption = Atajos.getNum();
                    switch (getOption) {
                        case 1 ->
                            porCategorias(listLister);
                        case 2 -> {
                            boolean delete = false;
                            Atajos.buscarOBorrar(listLister, delete);
                        }
                        default -> {
                            Atajos.imprimir("Volviendo al menu de administrador");
                            return;
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
                }
                case 4 -> {
                    try {
                        if (listLister.getCarrito().isEmpty()) {
                            Atajos.imprimir("El carrito está vacío. No se puede realizar la compra.");
                            break;
                        } else {
                            double total = 0.0;
                            for (Producto p : listLister.getCarrito()) {
                                Atajos.imprimir(p.showData(listLister.getCarrito().indexOf(p) + 1));
                                total += p.getPrice();
                            }
                            Atajos.imprimir("Total a pagar: " + total);
                            Atajos.imprimir("¿Desea confirmar la compra? (s/n)");
                            String respuesta = Atajos.getTexto();
                            if (respuesta.equalsIgnoreCase("s")) {
                                if (isLog) {
                                    Atajos.imprimir("desea aplicár un cupon de descuento (s/n)");
                                    String cupon = Atajos.getTexto();
                                    Atajos.imprimirSeparador();

                                    if (cupon.equalsIgnoreCase("s")) {
                                        Atajos.imprimir("introdcuce el codigo:");
                                        String cupon2 = Atajos.getTexto();
                                        try {
                                            if (listLister.getCupones().containsKey(cupon2)) {
                                                double descuento = listLister.getCupones().get(cupon2).intValue();
                                                descuento = 1 - (descuento / 100);
                                                total = total * descuento;
                                                Atajos.imprimirSeparador();
                                                Atajos.imprimir("Cupon válidoo, \ntotal:" + total + "€");
                                                Atajos.imprimirSeparador();
                                            } else {
                                                Atajos.imprimirSeparador();
                                                Atajos.imprimir("Cuppon no válido");
                                                Atajos.imprimirSeparador();
                                            }

                                        } catch (Exception e) {
                                            Atajos.imprimir("Erro cupon invalido");
                                        }
                                    }
                                }
                                Atajos.imprimir("Añada la cantidad de dinero necesaria para completar la compra:");
                                try {
                                    double dinero = Atajos.getNum();
                                    if (dinero >= total) {
                                        double cambio = dinero - total;
                                        Atajos.imprimir("Compra realizada con éxito.");
                                        Atajos.imprimir("Su cambio es: " + cambio + " € \n Muchas gracias por su compra.");
                                        listLister.setRecaudado(listLister.getRecaudado() + total);
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
                            } else {
                                Atajos.imprimir("Resppuesta no valida , intentalo de nuevo");

                            }
                        }
                    } catch (Exception e) {
                        Atajos.imprimir("Ha ocurrido un error durante el proceso de compra. Inténtelo de nuevo.");
                    }
                }
                case 5 -> {
                    Atajos.imprimir("Hasta la próxima.");
                    condition = false;
                }
                default ->
                    Atajos.imprimir("Opción no válida.");
            }

        } while (condition);
    }

    public static void porCategorias(ListLister listLister) {
        String[] categotias = {"Accesorios", "Juegos", "Herramientas", "Home", "Ropa"};
        Atajos.mostrarMenu(categotias);
        Atajos.imprimirSeparador();

        Atajos.imprimir("Seleciona una categoria");
        Atajos.imprimirSeparador();

        int numero = Atajos.getNum();
        if (numero < 1 || numero > categotias.length) {
            Atajos.imprimir("Categoria no encontrrada");
            Atajos.imprimirSeparador();

            return;
        }
        String categotiSelect = categotias[numero - 1];
        Atajos.imprimir(categotiSelect);
        List<Producto> productosFil = new ArrayList<>();
        for (Producto p : listLister.getProductos()) {
            switch (categotiSelect) {
                case "Accesorios" -> {
                    if (p instanceof Accesorios) {
                        productosFil.add(p);
                    }
                }
                case "Juegos" -> {
                    if (p instanceof Game) {
                        productosFil.add(p);
                    }
                }
                case "Herramientas" -> {
                    if (p instanceof Herramientas) {
                        productosFil.add(p);
                    }
                }
                case "Home" -> {
                    if (p instanceof Home) {
                        productosFil.add(p);
                    }
                }

                case "Ropa" -> {
                    if (p instanceof Ropa) {
                        productosFil.add(p);
                    }
                }
            }
        }
        if (productosFil.isEmpty()) {
            Atajos.imprimir("no ha categorrias");
            Atajos.imprimirSeparador();

        } else {
            Atajos.imprimir("Productos en la categoría " + categotiSelect + ":");
            for (int i = 0; i < productosFil.size(); i++) {
                Atajos.imprimir(productosFil.get(i).showData(i + 1));

            }
            Atajos.imprimirSeparador();
            Atajos.imprimir("Seleccione un producto del menú mostrando un número:");
            int num = Atajos.getNum();
            if (num < 1 || num > productosFil.size()) {
                Atajos.imprimir("Número inválido. Por favor, seleccione un número válido.");
                Atajos.imprimirSeparador();

            } else {
                boolean comprado = true;
                if (productosFil.get(num - 1).getStock() <= 0) {
                    Atajos.imprimir("Lo sentimos, el producto está agotado y no se puede agregar al carrito.");
                    Atajos.imprimirSeparador();

                } else {
                    Atajos.agragarAlCarrito(listLister, productosFil, num, comprado);
                }
            }
        }
    }
}
