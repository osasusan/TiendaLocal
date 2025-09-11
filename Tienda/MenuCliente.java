package Tienda;

import Productos.Producto;

public class MenuCliente {

    public static void menuCliente(ListLister listLister) {

        Producto[] random = new Producto[5];
        int[] randomIndices = Atajos.fiveRandom(listLister.getProductos().size());
        Atajos.imprimir("Productos destacados:");
        for (int i = 0; i < 5; i++) {
            random[i] = listLister.getProductos().get(randomIndices[i]);
            Atajos.imprimir((i + 1) + ". " + random[i].showData());
        }

        Atajos.imprimirSeparador();
        Atajos.imprimir("Bienvenido al menú de cliente");
        Atajos.imprimirSeparador();
        Atajos.mostrarMenu(new String[]{"Productos destacados", "Agregar al carrito", "Realizar compra"});
        int opcion = Atajos.getNum();

        boolean condition = false;
        while (!condition) {

            switch (opcion) {
                case 1 -> {
                    Atajos.imprimir("Productos destacados:");
                    for (int i = 0; i < random.length; i++) {
                        Atajos.imprimir((i + 1) + ". " + random[i].showData());
                    }
                    Atajos.imprimirSeparador();
                    Atajos.imprimir("Seleccione un producto del menú mostrando un número:");
                    int num = Atajos.getNum();
                   Atajos.imprimir(random[num - 1].showData());
                    break;
                }
                case 2 -> {
                    Atajos.imprimir("Funcionalidad de agregar al carrito en desarrollo.");
                }
                case 3 -> {
                    Atajos.imprimir("Funcionalidad de realizar compra en desarrollo.");
                }
                case 4 -> {
                    Atajos.imprimir("Hasta la próxima.");
                    condition = true;
                }
                default ->
                    Atajos.imprimir("Opción no válida.");
            }
        }
    }
}
