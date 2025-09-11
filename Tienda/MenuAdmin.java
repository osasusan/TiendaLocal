package Tienda;

public class MenuAdmin {

    public static void menuAdmin(ListLister listLister) {
        Atajos.imprimir("Bienvenido al menú de administrador");
        Atajos.imprimirSeparador();
        Atajos.mostrarMenu(new String[]{"Agregar producto", "Eliminar producto", "Modificar producto"});
        int opcion = Atajos.getNum();

        switch (opcion) {
            case 1 -> {
                Atajos.imprimir("Funcionalidad de agregar producto en desarrollo.");
            }
            case 2 -> Atajos.imprimir("Funcionalidad de eliminar producto en desarrollo.");
            case 3 -> Atajos.imprimir("Funcionalidad de modificar producto en desarrollo.");
            default -> Atajos.imprimir("Opción no válida.");
             
        }
    }
}
