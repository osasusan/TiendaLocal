package Tienda;

import Productos.Accesorios;
import Productos.Game;
import Productos.Herramientas;
import Productos.Home;
import Productos.Producto;
import Productos.Ropa;
import Usuarios.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuAdmin {

    public static void menuAdmin(ListLister listLister) {
        Atajos.imprimir("Bienvenido al menú de administrador");
        boolean salir = false;
        do {
            Atajos.imprimirSeparador();
            Atajos.mostrarMenu(new String[]{
                "Agregar producto ",
                "Añadir Stock",
                "Dar de baja un producto",
                "Ver dinero recaudado",
                "Ver todos los usuarios registrados",
                "Añadir cup�n",
                "Eliminar cupon"});
            Atajos.imprimirSeparador();
            int opcion = Atajos.getNum();
            Atajos.imprimirSeparador();
            switch (opcion) {
                case 1 -> {
                    String[] categotias = {"Accesorio", "Juego", "Herramienta", "Home", "Ropa"};
                    Atajos.mostrarMenu(categotias);
                    Atajos.imprimir("Indica el tipo de porducto que desea añadir");
                    Atajos.imprimirSeparador();
                    int num = Atajos.getNum();
                    Atajos.imprimirSeparador();

                    if (num < 1 || num > categotias.length) {
                        Atajos.imprimir("este tipo no es valido");
                    } else {
                        String tipoProducto = categotias[num - 1];
                        Producto nuevoProducto = null;
                        switch (tipoProducto) {
                            case "Accesorio" ->
                                nuevoProducto = new Accesorios();
                            case "Juego" ->
                                nuevoProducto = new Game();
                            case "Herramienta" ->
                                nuevoProducto = new Herramientas();
                            case "Home" ->
                                nuevoProducto = new Home();
                            case "Ropa" ->
                                nuevoProducto = new Ropa();
                            default ->
                                Atajos.imprimir("Tipo de producto no reconocido.");
                        }
                        if (nuevoProducto != null) {
                            listLister.getProductos().add(nuevoProducto);
                            Atajos.imprimir("Has añadido " + nuevoProducto.getName() + " corretament");
                        }
                    }
                    Atajos.imprimirSeparador();
                    Atajos.imprimir("Funcionalidad de agregar producto en desarrollo.");
                }
                case 2 -> {

                    Atajos.imprimir("di el nombre del producto al que quieres actualizar el stock");
                    String nombreP = Atajos.getTexto();
                    List<Producto> actualizarStockk = new ArrayList<>();
                    for (Producto p : listLister.getProductos()) {
                        if (p.getName().toLowerCase().contains(nombreP.toLowerCase())) {
                            actualizarStockk.add(p);
                        }
                    }
                    if (actualizarStockk.isEmpty()) {
                        Atajos.imprimir("Producto no encontrado");
                        return;
                    }
                    Atajos.imprimir("Productos encontrados:");
                    for (int i = 0; i < actualizarStockk.size(); i++) {
                        Atajos.imprimir((i + 1) + ". " + actualizarStockk.get(i).showData(i + 1));
                    }
                    Atajos.imprimir("Indique le porducto a actualizat");
                    int num = Atajos.getNum();
                    if (num < 1 || num > actualizarStockk.size()) {
                        Atajos.imprimir("numero no es valido");
                    } else {
                        Producto productoOriginal = actualizarStockk.get(num - 1);
                        productoOriginal.getCantidad();  // Esto ya pide el stock nuevo y actualiza

                    }
                }
                case 3 -> {

                    var delete = true;
                    Atajos.buscarOBorrar(listLister, delete);
                }
                case 4 -> {

                    if (listLister.getRecaudado() != 0.0) {
                        Atajos.imprimir("has recaudado : " + listLister.getRecaudado());
                    } else {
                        Atajos.imprimir("No has recaudado nada todavia");
                    }
                }
                case 5 -> {
                    Atajos.imprimir("Listra de usuarios Registrados");
                    for (Map.Entry<String, Usuario> listUsEntry : listLister.getUsers().entrySet()) {
                        String username = listUsEntry.getKey();
                        Usuario usuario = listUsEntry.getValue();
                        Atajos.imprimir("Usuario: " + username + " " + usuario.showData());
                    }

                }
                case 6 -> {

                    Atajos.imprimir("Indique la clave del nuevo cupon");
                    Atajos.imprimirSeparador();
                    String nuevoCupon = Atajos.getTexto();

                    Atajos.imprimir("Indique el desceunto que quiere que tenga este cupon");
                    Atajos.imprimirSeparador();
                    double des = Atajos.getDouble();

                    listLister.getCupones().put(nuevoCupon, des);
                    Atajos.imprimirSeparador();
                    Atajos.imprimir("se ha añadido con exito el nuevo cupon");

                }
                case 7 -> {
                    Atajos.imprimirSeparador();
                    Atajos.imprimir("introduce el cupon que quierres eleiminar");
                    String deleteCupon = Atajos.getTexto();
                    if (listLister.getCupones().containsKey(deleteCupon)) {
                        listLister.getCupones().remove(deleteCupon);
                        Atajos.imprimir("Se ha eliminado correctamente, \nVolviuendo al menu Admin...");

                    } else {
                        Atajos.imprimir("No Se ha encontrado el cupon \ne ha cancelado la elimiacion volivierndo al menu admin");
                    }
                }
                case 8 -> {
                    Atajos.imprimir("Hasta la porxima Administrador");
                    salir = true;
                }
                default ->
                    Atajos.imprimir("Opción no válida.");

            }
        } while (!salir);
    }
}
